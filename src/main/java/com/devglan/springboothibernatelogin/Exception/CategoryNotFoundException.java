package com.devglan.springboothibernatelogin.Exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Integer id) {
        super("Could not find category with id " + id + ".");
    }
}
