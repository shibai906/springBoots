package com.zhao.springboot.service;

import com.zhao.springboot.dao.test.PersonMapper;
import com.zhao.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonMapper personMapper;


    public long insert(Person person)  {
        try {
            personMapper.insert(person);
            if(person.getName().equals("zhao")) {
                throw new Exception("错误");
            }

            return personMapper.insert(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
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
