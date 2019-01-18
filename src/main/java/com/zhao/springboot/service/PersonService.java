package com.zhao.springboot.service;

import com.zhao.springboot.dao.test.PersonMapper;
import com.zhao.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonMapper personMapper;

    @Transactional(value = "testTransactionManager" , rollbackFor=Exception.class)
    public long insert(Person person) throws Exception  {

            personMapper.insert(person);
            if(person.getName().equals("zhao")) {
                throw new Exception("错误");
            }

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
