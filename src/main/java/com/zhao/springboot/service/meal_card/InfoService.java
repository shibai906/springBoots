package com.zhao.springboot.service.meal_card;

import com.zhao.springboot.dao.mealCard.MCInfoMapper;
import com.zhao.springboot.entity.meal_card.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    MCInfoMapper mcInfoMapper;

    public long insert(Info info) {
        long time = System.currentTimeMillis();
        info.setCreateTime(time);
        info.setUpdateTime(time);

        return mcInfoMapper.insert(info);
    }

    public void update(Info info) {
        info.setUpdateTime(System.currentTimeMillis());
        mcInfoMapper.update(info);
    }

    public void delete(long id) {
        mcInfoMapper.delete(id);
    }

    public List<Info> getAll() {
        return mcInfoMapper.getAll();
    }

}
