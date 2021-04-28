package com.devglan.springboothibernatelogin.dao;

import com.devglan.springboothibernatelogin.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
//repositories for accessing the data from the database
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

        //find product by category id
        List<Product> findAllByCategoryId(int categpryId);

}
