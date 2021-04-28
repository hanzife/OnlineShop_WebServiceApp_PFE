package com.devglan.springboothibernatelogin.service.impl;

import com.devglan.springboothibernatelogin.dao.CategoryRepository;
import com.devglan.springboothibernatelogin.dao.ProductRepository;
import com.devglan.springboothibernatelogin.model.Category;
import com.devglan.springboothibernatelogin.model.Product;
import com.devglan.springboothibernatelogin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service("ProductService") //This annotation is a specialization of the @Component annotation, it is used to mark the class as a service provider.
public class ProductServiceImp implements ProductService {

    final ProductRepository productRepository;//: Our dependency injection annotation, autowiring our application is fundamental when building it.

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductByCategory(int id) {
        List<Product> products = productRepository.findAllByCategoryId(id);
        if(products.isEmpty()) {
            throw new RuntimeException("Category Not Found");
        }
        return products;
    }

    public Optional<Product> getProduct(long id){
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            throw new RuntimeException("Product Not Found");
        }
        return product;
    }
}
