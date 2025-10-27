package com.example.demoboot.repository;

import com.example.demoboot.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepository implements Repository<Employee, Integer> {

    private List<Employee> employeeList;

    /*
     On cree des employés pour simuler un stockage
     */
    public EmployeeRepository(){
        this.employeeList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Employee e = new Employee();
            e.setId(i+1);
            e.setUsername("Monsieur_"+(i+1));
            this.employeeList.add(e);
        }
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeList;
    }

    @Override
    public Employee getById(Integer id) {
        for (Employee e: employeeList){
            if (e.getId().equals(id)){
                return e;
            }
        }
        throw new IllegalArgumentException("employee not found : "+id);
    }

    @Override
    public void create(Employee emp) {
        for (Employee e: employeeList){
            if (e.getId().equals(emp.getId())){
                throw new IllegalArgumentException(
                        "Employee with id : "+ emp.getId()+ " already exist"
                );
            }
        }
        employeeList.add(emp);
    }

    @Override
    public void update(Integer id, Employee emp) {
        for (Employee e: employeeList){
            if (e.getId().equals(emp.getId())){
                e.setUsername(emp.getUsername());
                return;
            }
        }
        throw new IllegalArgumentException(
                "Employee not found "+ emp
        );
    }

    @Override
    public Employee delete(Integer id) {
        for (Employee e: employeeList){
            if (e.getId().equals(id)){
                Employee deleted_emp = e;
                employeeList.remove(e);
                return deleted_emp;
            }
        }
        throw new IllegalArgumentException(
                "Employee not found with id :"+ id
        );
    }
}
