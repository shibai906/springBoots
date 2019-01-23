package com.zhao.springboot.service.meal_card;

import com.zhao.springboot.dao.mealCard.ConsumeMapper;
import com.zhao.springboot.entity.meal_card.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeService {

    @Autowired
    ConsumeMapper consumeMapper;

    public long insert(Consume consume) {
        long time = System.currentTimeMillis();
        consume.setConsumeTime(time);
        return consumeMapper.insert(consume);
    }

    public List<Consume> getAll(int number) {
        return consumeMapper.getAll(number);


    }

}
