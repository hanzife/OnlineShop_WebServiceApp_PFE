package com.devglan.springboothibernatelogin.service.impl;

import com.devglan.springboothibernatelogin.dao.ProductRepository;
import com.devglan.springboothibernatelogin.dto.ImageDto;
import com.devglan.springboothibernatelogin.model.Product;
import com.devglan.springboothibernatelogin.service.ImageService;
import org.springframework.beans.BeanUtils;
import  org.springframework.util.StringUtils;
import com.devglan.springboothibernatelogin.dao.ImageRepository;
import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServiceImp implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    //public ApiResponse saveImage(long productId, MultipartFile file) throws IOException{
    public ApiResponse saveImage(long productID, ImageDto imageDto){

        String message ="";

        try {

            productRepository.findById(productID).orElseThrow(() -> new RuntimeException("Product not found with id " + productID));

            Image image = new Image();
            BeanUtils.copyProperties(imageDto, image);
            image.setProduct(productRepository.findProductById(productID));

            imageRepository.save(image);
            message ="Image was inserted";
            return new ApiResponse(200,message, image);
        }
        catch (Exception e){
            message ="error inserting image";
            return new ApiResponse(200, e.getMessage(), message);
        }

    }
/*
    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
    */

}
