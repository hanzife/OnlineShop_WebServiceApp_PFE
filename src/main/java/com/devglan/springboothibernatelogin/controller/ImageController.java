package com.devglan.springboothibernatelogin.controller;


import com.devglan.springboothibernatelogin.dao.ImageRepository;
import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.service.ImageService;
import com.devglan.springboothibernatelogin.service.impl.ImageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/image")
    public ApiResponse uploadImage(@RequestParam("file")MultipartFile file) throws IOException {

        return  imageService.saveImage(file);

    }
}
