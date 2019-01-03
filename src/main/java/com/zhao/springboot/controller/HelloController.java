package com.zhao.springboot.controller;

import com.zhao.springboot.entity.Persion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;

    @Autowired
    private Persion persion;

    @RequestMapping("/hello")
    public String hello() {
        return content;
    }

    @RequestMapping("/persion")
    public String persion() {
        return persion.toString();
    }

    @RequestMapping("/test")
    public String test() {
        return "test me to";
    }

}
