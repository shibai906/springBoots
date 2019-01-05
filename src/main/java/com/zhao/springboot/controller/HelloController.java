package com.zhao.springboot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhao.springboot.dao.TestMapper;
import com.zhao.springboot.entity.Persion;
import com.zhao.springboot.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    TestMapper testMapper;

/*
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
*/

    @RequestMapping(value = { "test" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object test() {
        List<Test> list = testMapper.findAll();
        JSONArray jsonArray = new JSONArray();
        for(Test test : list) {
            JSONObject jsonObject = new JSONObject() ;
            jsonObject.put("id",test.getId());
            jsonObject.put("username",test.getUsername());
            jsonArray.add(jsonObject);
        }


        return jsonArray;
    }

    @RequestMapping(value = { "/api/v1/test" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String hello(Model model) {
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }

}
