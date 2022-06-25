package com.geekbrains.geekmarketwinter.services;

import contract.entities.Product;
import contract.entities.ProductDTO;
import contract.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service-client", contextId = "user-service")
public interface UserFeignService {


    @GetMapping("/findByUserName/{userName}")
    User findByUserName(@PathVariable("userName") String userName);


    @GetMapping("/getAllUsers")
    List<User> findAll();

    @RequestMapping("/saveUser")
    void saveUser(@RequestBody User user);
}
