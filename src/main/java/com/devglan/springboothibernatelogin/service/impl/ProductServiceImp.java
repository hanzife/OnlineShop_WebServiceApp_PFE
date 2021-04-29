package com.devglan.springboothibernatelogin.service.impl;

import com.devglan.springboothibernatelogin.dao.CategoryRepository;
import com.devglan.springboothibernatelogin.dao.ProductRepository;
import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.ProductDto;
import com.devglan.springboothibernatelogin.model.Category;
import com.devglan.springboothibernatelogin.model.Product;
import com.devglan.springboothibernatelogin.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service("ProductService") //This annotation is a specialization of the @Component annotation, it is used to mark the class as a service provider.
public class ProductServiceImp implements ProductService {

    final ProductRepository productRepository;

    @Autowired //: Our dependency injection annotation, autowiring our application is fundamental when building it.
    CategoryRepository categoryRepository;


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

    public ApiResponse createProduct(int categoryId, ProductDto productDto){

        categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));

        Optional<Product> productExist = productRepository.findProductByNameProduct(productDto.getNameProduct());
        if (productExist.isPresent()){
            throw new RuntimeException("Product named " + productDto.getNameProduct() + " Already Exist" );
        }

        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        System.out.println(product);
        product.setCategory(categoryRepository.findCategoryById(categoryId));
        System.out.println( product.getCategory());
        System.out.println(product);
        productRepository.save(product);

        return new ApiResponse(200, "Product was added", product);
    }
}
