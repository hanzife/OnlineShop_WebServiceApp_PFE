package com.devglan.springboothibernatelogin.controller;


import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.ImageDto;
import com.devglan.springboothibernatelogin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/image")
    public ApiResponse uploadImage(@RequestBody ImageDto imageDto) {
        return  imageService.saveImage(imageDto.getProduct(), imageDto);
    }

}
