package com.geekbrains.services;

import com.geekbrains.repositories.UserRepositoryUS;
import contract.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepositoryUS userRepositoryUS;


    public User findByUserName(String userName) {
        System.out.println("Test find user 3");
        return userRepositoryUS.findOneByUserName(userName);
    }

    public List<User> findAll() {

        return userRepositoryUS.findAll();
    }
}
