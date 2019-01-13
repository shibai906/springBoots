package com.zhao.springboot.service;

import com.zhao.springboot.dao.test.PersonMapper;
import com.zhao.springboot.entity.Persion;
import com.zhao.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonMapper personMapper;

    public long insert(Person person) {
        return personMapper.insert(person);
    }

    public void update(Person person) {
        personMapper.update(person);
    }

    public List<Person> getAll() {
        return personMapper.findAll();
    }

    public void delete(long id) {
        personMapper.delete(id);
    }
}
