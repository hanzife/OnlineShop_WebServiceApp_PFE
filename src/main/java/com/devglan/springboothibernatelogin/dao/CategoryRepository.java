package com.devglan.springboothibernatelogin.dao;

import com.devglan.springboothibernatelogin.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//from Spring and its purpose is simply to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findCategoryById(Integer id);

}