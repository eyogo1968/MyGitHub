package com.example.demo.repository;

import com.example.demo.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    public List<Customer> selectAll();
    public Customer findById(String id);
    public Customer findByFirstName(String firstname);
    public Customer findByLastName(String lastname);
    public void update(String id, Customer customer);
    public void insert(Customer customer);
    public void delete(String id);
}
