package com.devglan.springboothibernatelogin.service;

import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.ProductDto;
import com.devglan.springboothibernatelogin.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductService {

    List<Product> getProductByCategory(int id);
    Optional<Product> getProduct(long id);
    ApiResponse createProduct(int categoryId, ProductDto productDto);

}
