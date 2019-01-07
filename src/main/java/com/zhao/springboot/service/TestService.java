package com.zhao.springboot.service;

import com.zhao.springboot.dao.test.TestMapper;
import com.zhao.springboot.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

    public List<Test> getAllTest() {
        return testMapper.findAll();
    }

    public long insert(Test test) {
        return testMapper.insert(test);
    }

    public void update(Test test) {
        testMapper.update(test);
    }

    public void delete(long id) {
        testMapper.delete(id);
    }

}
