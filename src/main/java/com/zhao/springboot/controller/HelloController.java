package com.zhao.springboot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhao.json.JSONResult;
import com.zhao.springboot.entity.Student;
import com.zhao.springboot.entity.Test;
import com.zhao.springboot.service.Test1;
import com.zhao.springboot.service.TestService;
import org.eclipse.jdt.internal.compiler.ast.Invocation;
import org.springframework.beans.factory.annotation.Autowired;
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
    TestService testService;

    @Autowired
    Test1 test1;
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

    @RequestMapping(value = { "getAllTest" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object getAllTest() {
        List<Test> list = testService.getAllTest();
        JSONArray jsonArray = new JSONArray();
        for(Test test : list) {
            JSONObject jsonObject = new JSONObject() ;
            jsonObject.put("id",test.getId());
            jsonObject.put("username",test.getUsername());
            jsonArray.add(jsonObject);
        }
        return JSONResult.success(jsonArray);
    }

    @RequestMapping(value = { "insertTest" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object insertTest(Test test) {
        long num = testService.insert(test);
        return JSONResult.success(num);
    }

    @RequestMapping(value = { "update" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object updateTest(Test test) {
        testService.update(test);
        return JSONResult.success();
    }

    @RequestMapping(value = { "delete" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object deleteTest(long id) {
        testService.delete(id);
        return JSONResult.success();
    }

    @RequestMapping(value = { "/api/v1/test" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object hello(Model model) {
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return JSONResult.success();
    }

    @RequestMapping(value = { "insert" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object insert( Student student) {
        test1.insert(student);
        return JSONResult.success();
    }

    @RequestMapping(value = { "findAll" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object findAll( Student student) {
        List<Student> list = test1.findAll();
        JSONArray jsonArray = new JSONArray();
        for(Student test : list) {
            JSONObject jsonObject = new JSONObject() ;
            jsonObject.put("id",test.getId());
            jsonObject.put("username",test.getName());
            jsonArray.add(jsonObject);
        }
        return JSONResult.success(jsonArray);
    }


}
