package com.zhao.springboot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhao.json.JSONResult;
import com.zhao.springboot.entity.meal_card.Consume;
import com.zhao.springboot.entity.meal_card.Info;
import com.zhao.springboot.service.meal_card.ConsumeService;
import com.zhao.springboot.service.meal_card.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mc")
public class MeadCardController {

    @Autowired
    InfoService infoService;

    @Autowired
    ConsumeService consumeService;

    @RequestMapping(value = { "insertInfo" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object insertInfo(Info info) {
        long id = infoService.insert(info);
        return JSONResult.success(id);
    }

    @RequestMapping(value = { "updateInfo" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object updateInfo(Info info) {
        infoService.update(info);
        return JSONResult.success();
    }

    @RequestMapping(value = { "deleteInfo" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object deleteInfo(long id) {
        infoService.delete(id);
        return JSONResult.success();
    }


    @RequestMapping(value = { "getAllInfo" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object getAllInfo() {
        List<Info> list = infoService.getAll();
        JSONArray jsonArray = new JSONArray() ;
        for(Info info : list) {
            JSONObject json = new JSONObject();
            json.put("id",info.getId());
            json.put("entrenceTime",info.getEntranceTime());
            json.put("createTime",info.getCreateTime());
            json.put("updateTime",info.getUpdateTime());
            json.put("number",info.getNumber());
            json.put("name",info.getName());
            jsonArray.add(json);
        }
        return JSONResult.success(jsonArray);
    }

    @RequestMapping(value = { "insertConsume" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object insertConsume(Consume consume) {
        consumeService.insert(consume);
        return JSONResult.success();
    }

    @RequestMapping(value = { "getAllConsume" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object getAllConsume(int number) {
        List<Consume> consumes = consumeService.getAll(number);
        JSONArray jsonArray = new JSONArray();
        for(Consume consume : consumes) {
            JSONObject json = new JSONObject();
            json.put("id",consume.getId());
            json.put("number",consume.getNumber());
            json.put("money",consume.getMoney());
            json.put("createTime",consume.getConsumeTime());
            jsonArray.add(json);
        }
        return JSONResult.success(jsonArray);
    }

}
