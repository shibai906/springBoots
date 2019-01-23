package com.zhao.springboot.dao.mealCard;

import com.zhao.springboot.entity.meal_card.Info;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MCInfoMapper {

    String tableName = "info";

    String columns = "id,number,name,entrance_time,create_time,update_time";

    @Insert("insert into " + tableName + "(number,name,entrance_time,create_time,update_time) " +
            "values(#{info.number},#{info.name},#{info.entranceTime},#{info.createTime},#{info.updateTime})")
    long insert(@Param("info") Info info);

    @Update("update " + tableName + " set " +
            "number=#{info.number},name=#{info.name},entrance_time=#{info.entranceTime},create_time=#{info.createTime},update_time=#{info.updateTime}"
            + " where id=#{info.id}"
    )
    void update(@Param("info") Info info);

    @Delete("delete from " + tableName + " where id=#{id}")
    void delete(@Param("id") long id) ;

    @Select("select " + columns + " from " + tableName)
    @Results({
            @Result(property = "entranceTime",column = "entrance_time"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "updateTime",column = "update_time")
    })
    List<Info> getAll() ;

}
