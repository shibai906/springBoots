package com.zhao.springboot.dao.test1;

import com.zhao.springboot.entity.Student;
import com.zhao.springboot.entity.Test;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Test1Mapper {

    @Select("select id,name from student")
    List<Student> findAll();

    @Insert("insert into student(name) values(#{test.name})")
    long insert(@Param("test") Student student);

    @Update("update student set username=#{test.name} where id=#{test.id}")
    int update(@Param("test") Student student);

    @Delete("delete from student where id=#{id}")
    void delete(@Param("id") long id);

}
