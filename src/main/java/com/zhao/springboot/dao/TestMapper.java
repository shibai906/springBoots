package com.zhao.springboot.dao;

import com.zhao.springboot.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("select id,username from test")
    List<Test> findAll();
}
