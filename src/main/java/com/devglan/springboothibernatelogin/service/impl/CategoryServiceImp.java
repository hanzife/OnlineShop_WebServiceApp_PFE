package com.devglan.springboothibernatelogin.service.impl;

import com.devglan.springboothibernatelogin.Exception.CategoryNotFoundException;
import com.devglan.springboothibernatelogin.dao.CategoryRepository;
import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.CategoryDto;
import com.devglan.springboothibernatelogin.dto.LoginDto;
import com.devglan.springboothibernatelogin.dto.SignUpDto;
import com.devglan.springboothibernatelogin.model.Category;
import com.devglan.springboothibernatelogin.model.User;
import com.devglan.springboothibernatelogin.service.CategoryService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category createCategory(Category user) {
        return categoryRepository.save(user);
    }

    public Optional<Category> getCategory(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()) {
            throw new RuntimeException("Category Not Found");
        }
        return category;
    }

    public void deleteCategory(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()) {
            throw new RuntimeException("Category Not Found");
        }
        else
            categoryRepository.deleteById(id);
    }

    //Update Category
    public Category updateCatedory(int id, Category category) {
        Optional<Category> editCategory= categoryRepository.findById(id);
        if (!editCategory.isPresent()) {
            throw new CategoryNotFoundException(id);
        } else {
            categoryRepository.findById(id);
            System.out.println(category.getLableCategory());
        }
        return categoryRepository.save(category);
    }
}
