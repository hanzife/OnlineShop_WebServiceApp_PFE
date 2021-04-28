package com.devglan.springboothibernatelogin.service;

import com.devglan.springboothibernatelogin.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductService {

    List<Product> getProductByCategory(int id);
    Optional<Product> getProduct(long id);

}
