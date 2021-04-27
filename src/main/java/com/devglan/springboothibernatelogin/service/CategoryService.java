package com.devglan.springboothibernatelogin.service;

import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.model.Category;

import java.util.Optional;


//Interface:
public interface CategoryService {

     //Calling Methods
     Category createCategory(Category user);
     Optional<Category> getCategory(int id);
     void deleteCategory(Integer id);
     Category updateCatedory(int id, Category category);

}
