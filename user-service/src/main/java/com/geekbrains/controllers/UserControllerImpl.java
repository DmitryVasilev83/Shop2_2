package com.geekbrains.controllers;

import com.geekbrains.services.UserService;
import contract.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController{

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User findByUserName(String userName) {
        System.out.println("Test find user 2");
        return userService.findByUserName(userName);
    }


    @GetMapping("/getAllUsers")
    public List<User> findAll(){

        return userService.findAll();
    };
}