package com.geekbrains.geekmarketwinter.controllers;

import com.ctc.wstx.shaded.msv.org_jp_gr_xml.xml.UXML;
import com.geekbrains.geekmarketwinter.entities.User;
import com.geekbrains.geekmarketwinter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showAdminDashboard(Model model) {

        List<User> users = userService.getAllUsers();
        model.addAttribute("users" , users);
        //test
        System.out.println("test - " + users.get(0).getUserName());

        return "admin-panel";
    }
    
}
