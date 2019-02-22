package com.zhao.springboot.service.Redis;

import com.zhao.springboot.utils.RedisCacheConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;

//@Service
public class RedisService {

   /* @Autowired
    private RedisTemplate redis;

    public void set(String key,String value){
        ValueOperations<Serializable, Object> operations = redis.opsForValue();
        operations.set(key,value);
    }

    public String get(String key) {
        ValueOperations<Serializable, Object> operations = redis.opsForValue();
        String string = (String) operations.get(key);
        return string;
    }*/

}
