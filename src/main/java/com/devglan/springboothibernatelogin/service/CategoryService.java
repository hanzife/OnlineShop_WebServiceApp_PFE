package com.devglan.springboothibernatelogin.service;

import com.devglan.springboothibernatelogin.dto.CategoryDto;
import com.devglan.springboothibernatelogin.model.Category;

public interface CategoryService {

    CategoryDto getCategoryById(int Id);
}
