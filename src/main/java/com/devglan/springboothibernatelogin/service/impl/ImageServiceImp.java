package com.devglan.springboothibernatelogin.service.impl;

import com.devglan.springboothibernatelogin.service.ImageService;
import  org.springframework.util.StringUtils;
import com.devglan.springboothibernatelogin.dao.ImageRepository;
import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImp implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ApiResponse saveImage(MultipartFile file) throws IOException{

        String message ="";
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            System.out.println(fileName);
            System.out.println( file.getContentType());
            System.out.println( file.getBytes());
            Image image = new Image();
            image.setNameImage(fileName);
            image.setTypeImage(file.getContentType());
            image.setDataImage(file.getBytes());
            imageRepository.save(image);
            System.out.println( image.getDataImage());
            message ="Image was inserted";
            return new ApiResponse(200,message, image);
        }
        catch (Exception e){
            return new ApiResponse(200, e.getMessage(), null);
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
