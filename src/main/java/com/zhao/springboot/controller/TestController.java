package com.zhao.springboot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhao.json.JSONResult;
import com.zhao.springboot.entity.Person;
import com.zhao.springboot.service.PersonService;
import com.zhao.springboot.service.Redis.RedisService;
import com.zhao.springboot.service.TestService;
import com.zhao.springboot.utils.RedisCacheConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    com.zhao.springboot.utils.RedisCacheConfig RedisCacheConfig;

    @Autowired
    PersonService personService;

    @RequestMapping(value = { "insert" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object insert(Person person) throws Exception {
        long id = personService.insert(person);
        return JSONResult.success(id);
    }

    @RequestMapping(value = { "update" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object update(Person person) {
        personService.update(person);
        return JSONResult.success();
    }

    @RequestMapping(value = { "findAll" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object findAll() {

        List<Person> list = personService.getAll();
        JSONArray jsonArray = new JSONArray();
        for(Person person : list) {
            JSONObject json = new JSONObject();
            json.put("pno",person.getPno());
            json.put("id",person.getId());
            json.put("name",person.getName());
            json.put("sex",person.getSex());
            json.put("age",person.getAge());
            jsonArray.add(json);
        }
        return JSONResult.success(jsonArray);

    }

    @RequestMapping(value = { "delete" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object delete(long id) {

        personService.delete(id);
        return JSONResult.success();

    }

    @RequestMapping(value = { "set" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object set(String key,String value) {
        RedisCacheConfig.set(key,value);
        return JSONResult.success();
    }

    @RequestMapping(value = { "get" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object get(String key) {
        String value = (String) RedisCacheConfig.get(key);
        return JSONResult.success(value);
    }




}
