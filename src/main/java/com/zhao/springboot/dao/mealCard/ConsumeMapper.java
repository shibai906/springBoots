package com.zhao.springboot.dao.mealCard;

import com.zhao.springboot.entity.meal_card.Consume;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ConsumeMapper {

    String tableName = "consume" ;
    String columns = "id,money,consume_time,number" ;

    @Insert("insert into " + tableName + "(money,number,consume_time)" + " values(#{cs.money},#{cs.number},#{cs.consumeTime})" )
    long insert(@Param("cs") Consume consume) ;



    @Select("select " + columns + " from " + tableName + " where number=#{numbser}")
    List<Consume> getAll(@Param("number") int number) ;

}
