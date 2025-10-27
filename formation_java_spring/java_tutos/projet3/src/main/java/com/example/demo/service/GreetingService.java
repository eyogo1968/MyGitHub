package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class GreetingService  {

    @Autowired
    private GreetingRepository greetingRepository;


    public Collection<Greeting> findAll() {
        return greetingRepository.findAll();
    }

    public Greeting findOne(Long id) {
        return greetingRepository.findOne(id);
    }

    public Greeting create(Greeting greeting) {
        if (greeting.getId() != null){
            return null;
        }
        return  greetingRepository.create(greeting);
    }

    public Greeting update(Greeting greeting) {
        Greeting greetingPersisted = findOne(greeting.getId());
        if (greetingPersisted == null){
            return null;
        }
        return greetingRepository.update(greeting);
    }

    public void delete(Long id) {
        greetingRepository.delete(id);
    }
}
