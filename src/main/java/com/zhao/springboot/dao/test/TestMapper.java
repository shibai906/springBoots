package com.zhao.springboot.dao.test;

import com.zhao.springboot.entity.Test;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("select id,username from test")
    List<Test> findAll();

    @Insert("insert into test(username) values(#{test.username})")
    long insert(@Param("test") Test test);

    @Update("update test set username=#{test.username} where id=#{test.id}")
    int update(@Param("test") Test test);

    @Delete("delete from test where id=#{id}")
    void delete(@Param("id") long id);

}
