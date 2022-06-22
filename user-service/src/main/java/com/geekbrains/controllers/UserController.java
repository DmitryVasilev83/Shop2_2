package com.geekbrains.controllers;


import contract.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserController {

    @GetMapping("/findByUserName/{userName}")
    User findByUserName(@PathVariable("userName") String userName);

    @GetMapping("/getAllUsers")
    List<User> findAll();
}
