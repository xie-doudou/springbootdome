package com.xiedou.springbootjdbc.controller;

import com.xiedou.springbootjdbc.pojo.Users;
import com.xiedou.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {
   /* @Autowired
    private DataSource dataSource;*/
   @Autowired
   private UserService userService;

    @PostMapping("/addUser")
    public String addUser(Users users){

        this.userService.addUser(users);
        return "redirect:/ok";
    }
    @GetMapping("/findUserAll")
    public String findUserAll(Model model){
        List<Users> list=this.userService.findUserAll();

        model.addAttribute("list",list);
        return  "showUser";
    }

    @GetMapping("/updateInfo")
    public String showUpdateInfo(String username,Model model){
        Users users=this.userService.findUserByName(username);
        model.addAttribute("users",users);
        return "updateInfo";
    }

    @PostMapping("/updateUser")
    public String updateUser(Users users){
        this.userService.updateUser(users);
        return "redirect:/ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(String username){
        this.userService.deleteUser(username);
        return "redirect:/ok";
    }
}
