package com.xiedou.springbootmybatis.controller;


import com.xiedou.springbootmybatis.entity.User;
import com.xiedou.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public  String addUser(User user){
        this.userService.addUser(user);
        return "redirect:/ok";
    }

    @GetMapping("/findUserAll")
    public String showUserAll(Model model){
        List<User> list=this.userService.findUserAll();
        model.addAttribute("list",list);
        return "showUser";
    }

    @GetMapping("/updateInfo")
    public String updateInfo(String username,Model model){
        User user=this.userService.findUser(username);
        model.addAttribute("users",user);
        return "updateInfo";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user){
        this.userService.updateUser(user);
        return "redirect:/ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(String username){
        this.userService.deleteUser(username);
        return "redirect:/ok";
    }
}
