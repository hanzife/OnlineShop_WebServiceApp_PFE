package com.devglan.springboothibernatelogin.service;

import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.ImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    // ApiResponse saveImage(long productId,MultipartFile file) throws IOException;
    ApiResponse saveImage(long productId, ImageDto imageDto);

}
