package com.devglan.springboothibernatelogin.controller;

import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.LoginDto;
import com.devglan.springboothibernatelogin.dto.SignUpDto;
import com.devglan.springboothibernatelogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ApiResponse signUp(@RequestBody SignUpDto signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
}
