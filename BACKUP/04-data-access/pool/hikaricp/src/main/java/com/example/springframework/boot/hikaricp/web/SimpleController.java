package com.example.springframework.boot.hikaricp.web;

import com.example.springframework.boot.hikaricp.dao.UserDao;
import com.example.springframework.boot.hikaricp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String home() {
        return "hello HikariCP";
    }

    @GetMapping("/user/all")
    public List<User> getAllUser() {
        return userDao.findAll();
    }

}
