package com.devglan.springboothibernatelogin.service.impl;

import com.devglan.springboothibernatelogin.Exception.CategoryNotFoundException;
import com.devglan.springboothibernatelogin.dao.CategoryRepository;
import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.CategoryDto;
import com.devglan.springboothibernatelogin.dto.LoginDto;
import com.devglan.springboothibernatelogin.dto.SignUpDto;
import com.devglan.springboothibernatelogin.model.Category;
import com.devglan.springboothibernatelogin.model.Product;
import com.devglan.springboothibernatelogin.model.User;
import com.devglan.springboothibernatelogin.service.CategoryService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service //This annotation is a specialization of the @Component annotation, it is used to mark the class as a service provider.
public class CategoryServiceImp implements CategoryService {


    @Autowired //: Our dependency injection annotation, autowiring our application is fundamental when building it.
    CategoryRepository categoryRepository;

    @Override
    public ApiResponse createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setLableCategory(categoryDto.getLableCategory());
        BeanUtils.copyProperties(categoryDto, category);
        categoryRepository.save(category);
        return new ApiResponse(200, "success", category);
    }

    public Optional<Category> getCategory(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()) {
            throw new RuntimeException("Category Not Found");
        }
        return category;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()) {
            throw new RuntimeException("Category Not Found");
        }
        return categories;
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
        } else
            categoryRepository.findById(id);
            //categoryRepository.deleteById(id);

        return categoryRepository.save(category);
    }
}
