package com.example.demo.interfaces;

import com.example.demo.model.Greeting;

import java.util.Collection;
import java.util.List;

public interface IGreetingDataBase {

    List<Greeting> findByText(String text);

    Collection<Greeting> findAll();
    Greeting findOne(Long id);
    Greeting create(Greeting greeting);
    Greeting update(Greeting greeting);
    void delete(Long id);
}
