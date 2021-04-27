package com.devglan.springboothibernatelogin.service.impl;

import com.devglan.springboothibernatelogin.Exception.CategoryNotFoundException;
import com.devglan.springboothibernatelogin.dao.CategoryRepository;
import com.devglan.springboothibernatelogin.dto.CategoryDto;
import com.devglan.springboothibernatelogin.model.Category;
import com.devglan.springboothibernatelogin.service.CategoryService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImp {

    @Autowired
    CategoryRepository categoryRepository;

    public Category createCategory(Category user) {
        return categoryRepository.save(user);
    }

    public void deleteCategory(Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

            categoryRepository.deleteById(id);
    }
}
