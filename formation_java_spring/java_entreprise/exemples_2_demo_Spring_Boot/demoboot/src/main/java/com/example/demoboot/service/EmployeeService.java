package com.example.demoboot.service;

import com.example.demoboot.model.Employee;
import com.example.demoboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    //On peut demander à Spring de le fabriquer avec l'annotation
    //@Autowired
    //private final EmployeeRepository employeeRepository;

    // On peut le fabriquer dans le constructeur
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll(){
        return employeeRepository.getAll();
    }

    public Employee getById(Integer id) {
        return employeeRepository.getById(id);
    }

    public void create(Employee e) {
        employeeRepository.create(e);
    }

    public void update(Integer id, Employee e) {
        if (! e.getId().equals(id)){
            throw new IllegalArgumentException(
                    id + " ne correspond pas à : "+e
            );
        } else {
            employeeRepository.update(id, e);
        }
    }

    public Employee delete(Integer id) {
        return employeeRepository.delete(id);
    }
}
