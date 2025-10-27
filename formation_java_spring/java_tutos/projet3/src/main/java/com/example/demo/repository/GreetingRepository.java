package com.example.demo.repository;

import com.example.demo.interfaces.IGreetingDataBase;
import com.example.demo.model.Greeting;

import java.util.Collection;
import java.util.List;

public class GreetingRepository implements IGreetingDataBase {

    @Override
    public List<Greeting> findByText(String text) {
        return List.of();
    }

    @Override
    public Collection<Greeting> findAll() {
        return null;
    }

    @Override
    public Greeting findOne(Long id) {
        return null;
    }

    @Override
    public Greeting create(Greeting greeting) {
        return null;
    }

    @Override
    public Greeting update(Greeting greeting) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
