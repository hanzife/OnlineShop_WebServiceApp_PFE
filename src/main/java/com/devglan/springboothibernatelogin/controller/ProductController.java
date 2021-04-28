package com.devglan.springboothibernatelogin.controller;

import com.devglan.springboothibernatelogin.dao.CategoryRepository;
import com.devglan.springboothibernatelogin.dao.ProductRepository;
import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.model.Product;
import com.devglan.springboothibernatelogin.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.Optional;

@RestController
@RequestMapping
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Get the product by category
    @GetMapping("/categories/{categoryId}/products")
    public ApiResponse getProdyctByCategory(@PathVariable(value = "categoryId") int categoryId) {
        List<Product> products =  productService.getProductByCategory(categoryId);
        return new ApiResponse(200, "Products by Category", products);
    }

    //Get One Product
    @GetMapping("/products/{id}")
    public ApiResponse getProduct(@PathVariable long id) {
        Optional<Product> product =  productService.getProduct(id);
        return new ApiResponse(200, "Product:", product);
    }

}
