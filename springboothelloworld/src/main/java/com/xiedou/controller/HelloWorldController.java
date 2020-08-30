package com.xiedou.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//控制器
@RestController//@Controller+@ResponsBody 直接返回字符串
public class HelloWorldController {

    @RequestMapping("helloWorld")
    public  String showHelloWorld(){
        return "HelloWorld";
    }
}
