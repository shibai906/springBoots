package com.zhao.springboot;

import com.zhao.springboot.entity.Person;
import com.zhao.springboot.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    PersonService personService;

    @Test
    public void contextLoads() {
        List<Person> list = personService.getAll();
    }

}

