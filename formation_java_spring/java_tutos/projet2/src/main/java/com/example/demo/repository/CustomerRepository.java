package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerRepository implements ICustomerRepository{

    List<Customer> listCustomer;

   public CustomerRepository(){
       List<Customer> listCustomer = new ArrayList<Customer>();
        for (int i = 1; i  < 6;  i++){
            listCustomer.add(new Customer(""+i, "nom"+i, "prenom"+i));
        }
    }

    public List<Customer> selectAll(){
        return listCustomer;
    }

    public Customer findById(String id){
        return listCustomer.get(Integer.parseInt(id));
    }

    public Customer findByLastName(String lastname){
       for(Customer customer : listCustomer){
           if(lastname.equalsIgnoreCase(customer.getLastname())){
               return customer;
           }
       }
        return null;
    }

    public Customer findByFirstName(String firstname){
        for(Customer customer : listCustomer){
            if(firstname.equalsIgnoreCase(customer.getFirstname())){
                return customer;
            }
        }
        return null;
    }

    public void update(String id, Customer customer){
        Customer updatedCustomer = findById(id);
        delete(id);
        updatedCustomer.setId(customer.getId());
        updatedCustomer.setFirstname(customer.getFirstname());
        updatedCustomer.setLastname(customer.getLastname());
        listCustomer.add(updatedCustomer);
    }

    public void delete(String id){
        for(Customer customer : listCustomer){
            if(id.equalsIgnoreCase(customer.getId())){
                listCustomer.remove(customer);
                return;
            }
        }
    }

    public void insert(Customer customer){
        listCustomer.add(customer);
    }
}
