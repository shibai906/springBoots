package com.zhao.springboot.service;

import com.zhao.springboot.dao.test1.Test1Mapper;
import com.zhao.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test1 {

    @Autowired
    Test1Mapper test1Mapper;

    public void insert(Student student) {
        test1Mapper.insert(student);
    }

    public List<Student> findAll() {
        return test1Mapper.findAll();
    }

}
