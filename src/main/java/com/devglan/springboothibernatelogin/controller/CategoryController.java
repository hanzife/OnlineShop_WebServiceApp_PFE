package com.devglan.springboothibernatelogin.controller;

import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.CategoryDto;
import com.devglan.springboothibernatelogin.model.Category;
import com.devglan.springboothibernatelogin.model.User;
import com.devglan.springboothibernatelogin.service.CategoryService;
import com.devglan.springboothibernatelogin.service.impl.CategoryServiceImp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value ="/categories")
public class CategoryController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  ApiResponse createNewCategory(@RequestBody Category category) {

        Category newCategory = categoryServiceImp.createCategory(category);
        return new ApiResponse(200, "new category was added", newCategory);

    }

    @DeleteMapping( "categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse deleteCategory(@PathVariable Integer id) {
        System.out.println(id);
        categoryServiceImp.deleteCategory(id);
        return new ApiResponse(200, "category was deleted", id);
    }


}



