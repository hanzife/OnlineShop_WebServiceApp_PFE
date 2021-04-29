package com.devglan.springboothibernatelogin.service;

import com.devglan.springboothibernatelogin.dto.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    ApiResponse saveImage(MultipartFile file) throws IOException;
}
