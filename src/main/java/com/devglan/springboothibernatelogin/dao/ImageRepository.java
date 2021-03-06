package com.devglan.springboothibernatelogin.dao;

import com.devglan.springboothibernatelogin.model.Image;
import com.devglan.springboothibernatelogin.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repositories used with JpaRepository's methods sush as save(), findAll(), findById()...
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
