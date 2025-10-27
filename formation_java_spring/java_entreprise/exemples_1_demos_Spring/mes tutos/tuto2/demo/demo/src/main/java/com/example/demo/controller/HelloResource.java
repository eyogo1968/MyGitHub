package com.example.demo.controller;

import com.example.demo.domain.Hello;
import com.example.demo.domain.HelloRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloResource {

    private final HelloRepository helloRepository;

    public HelloResource(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @PostMapping("/tuto2/post/create/hello")
    public HelloDto create(@RequestBody HelloDto helloDto){
        Hello hello = helloRepository.save(new Hello(helloDto.param()));
        return new HelloDto(hello.getId(), hello.getParam());
    }

    @GetMapping("/tuto2/get/hello/{id}")
    public HelloDto get(@PathVariable Long id){
        Hello hello = helloRepository.findById(id).orElseThrow();
        return new HelloDto(hello.getId(), hello.getParam());
    }
}