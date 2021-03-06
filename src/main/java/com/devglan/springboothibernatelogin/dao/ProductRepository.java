package com.devglan.springboothibernatelogin.dao;

import com.devglan.springboothibernatelogin.model.Category;
import com.devglan.springboothibernatelogin.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

//repositories for accessing the data from the database
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

        Product findProductById(long id);

        //find product by category id
        List<Product> findAllByCategoryId(int categpryId);

        Optional<Product> findProductByNameProduct(String nameProduct);

}
