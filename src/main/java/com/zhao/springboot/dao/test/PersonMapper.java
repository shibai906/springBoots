package com.zhao.springboot.dao.test;


import com.zhao.springboot.entity.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonMapper {

    String tableName = "person" ;

    @Insert("insert into "+ tableName+"(pno,name,sex,age) value(#{ps.pno},#{ps.name},#{ps.sex},#{ps.age})")
    long insert(@Param("ps") Person person) ;

    @Select("select id,pno,name,sex,age from " + tableName)
    List<Person> findAll();

    @Delete("delete from " + tableName + " id=#{id}")
    void delete(@Param("id") long id);

    @Update("update " + tableName + " set pno=#{ps.pno},name=#{ps.name},sex=#{ps.sex},age=#{ps.age}")
    void update(@Param("ps")Person person);

}
