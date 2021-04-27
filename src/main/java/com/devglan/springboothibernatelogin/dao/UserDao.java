package com.devglan.springboothibernatelogin.dao;

import com.devglan.springboothibernatelogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    User findByEmail(String email);
}
