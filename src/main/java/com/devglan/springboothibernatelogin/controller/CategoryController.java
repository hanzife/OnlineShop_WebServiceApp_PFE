package com.devglan.springboothibernatelogin.controller;

import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.CategoryDto;
import com.devglan.springboothibernatelogin.dto.SignUpDto;
import com.devglan.springboothibernatelogin.model.Category;
import com.devglan.springboothibernatelogin.model.Product;
import com.devglan.springboothibernatelogin.model.User;
import com.devglan.springboothibernatelogin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController //Combines the @Controller and @ResponseBody annotations, which eliminates the need to annotate every request handling method of the controller class with @ResponseBody.
@RequestMapping
@CrossOrigin("http://localhost:4200") //Adapt port to agular server to let angular have access to backend
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    //Create : When given a valid HTTP POST request in /categories, create a specific user.
    // Maps our POST request onto our method.
    @PostMapping(path="/categories")
    // Ties our method parameter to the body of our HTTP request. This annotation indicates that the return type should be written straight to the HTTP response body (and not interpreted as a view name).
    public  ApiResponse createNewCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    //get : When given a valid HTTP GET request in /categories/{id}, retrieve the details of a specific user by its id.
    @GetMapping(path="/categories/{id}")
    //Straightforward way to set the status code of our HTTP response.
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getCategory(@PathVariable int id){
        Optional<Category> getCategory = categoryService.getCategory(id);
        return new ApiResponse(200, "category Found", getCategory);
    }

    //Get : All Categories
    @GetMapping(path="/all_categories")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getCategories() {
        List<Category> categories =  categoryService.getCategories();
        return new ApiResponse(200, "Categories", categories);
    }


    //Delete : When given a valid HTTP DELETE request in /users/{id}, delete a specific user by its id.
    @DeleteMapping( "categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse deleteCategory(@PathVariable int id) {
       categoryService.deleteCategory(id);
       return new ApiResponse(200, "category was deleted", id);
    }

    //Update : When given a valid HTTP PUT request in /users/{id}, update the details of a specific user by its id.
    @PutMapping( "categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse updateCategory(@RequestBody Category category, @PathVariable int id) {
        System.out.println("Controller "+ id);
        System.out.println("Controller from json"+ category.getId());
        categoryService.updateCatedory(id,category);
        return new ApiResponse(200, "category was updated", category);
    }


}



