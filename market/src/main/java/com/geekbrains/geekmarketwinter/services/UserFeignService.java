package com.geekbrains.geekmarketwinter.services;

import contract.entities.Product;
import contract.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "user-service-client", contextId = "user-service")
public interface UserFeignService {


//    @GetMapping("/findByUserName/{userName}")
    @RequestMapping(method = RequestMethod.GET, value ="/findByUserName/{userName}")
    User findByUserName(@PathVariable("userName") String userName);


    @GetMapping("/getAllUsers")
    List<User> findAll();
}
