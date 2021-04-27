package com.devglan.springboothibernatelogin.service;

import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.LoginDto;
import com.devglan.springboothibernatelogin.dto.SignUpDto;

public interface UserService {

    ApiResponse signUp(SignUpDto signUpDto);

    ApiResponse login(LoginDto loginDto);
}
