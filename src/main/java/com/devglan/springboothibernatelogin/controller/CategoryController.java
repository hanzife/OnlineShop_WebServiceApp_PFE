package com.devglan.springboothibernatelogin.controller;

import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.model.Category;
import com.devglan.springboothibernatelogin.model.User;
import com.devglan.springboothibernatelogin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(path="/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public  ApiResponse createNewCategory(@RequestBody Category category) {

        Category newCategory = categoryService.createCategory(category);
        return new ApiResponse(200, "new category was added", newCategory);

    }

    @GetMapping(path="/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getCategory(@PathVariable int id){
        Optional<Category> getCategory = categoryService.getCategory(id);
        return new ApiResponse(200, "category Found", getCategory);
    }

    @DeleteMapping( "categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse deleteCategory(@PathVariable int id) {
       categoryService.deleteCategory(id);
       return new ApiResponse(200, "category was deleted", id);
    }

    @PutMapping( "categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse  updateCategory(@RequestBody Category category, @PathVariable int id) {
        categoryService.updateCatedory(id,category);
        return new ApiResponse(200, "category was updated", category);
    }


}



