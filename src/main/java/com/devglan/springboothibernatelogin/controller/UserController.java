package com.devglan.springboothibernatelogin.controller;

import com.devglan.springboothibernatelogin.dto.ApiResponse;
import com.devglan.springboothibernatelogin.dto.LoginDto;
import com.devglan.springboothibernatelogin.dto.SignUpDto;
import com.devglan.springboothibernatelogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200") //Adapt port to agular server to let angular have access to backend
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
