package com.devglan.springboothibernatelogin.dao;

import com.devglan.springboothibernatelogin.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findCategoryById(Integer id);

}