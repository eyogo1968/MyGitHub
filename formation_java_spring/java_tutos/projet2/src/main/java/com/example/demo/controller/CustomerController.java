package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("")
    public List<Customer> selectAll(){
        return repository.selectAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable String id){
        return repository.findById(id);
    }

    @GetMapping("/search/lastname/{lastname}")
    public Customer findByLastName(@PathVariable String lastname){
        return repository.findByLastName(lastname);
    }

    @GetMapping("/search/firstname/{firstname}")
    public Customer findByFirstName(@PathVariable String firstname){
        return repository.findByFirstName(firstname);
    }

    @PostMapping("")
    public void insert(@RequestBody Customer customer){
        repository.insert(customer);
    }

    @PatchMapping ("/{id}")
    public void update(@RequestParam String id, @RequestBody Customer customer){
        repository.update(id,customer);
    }

    @DeleteMapping ("/{id}")
    public void delete(@RequestParam String id){
        repository.delete(id);
    }
}
