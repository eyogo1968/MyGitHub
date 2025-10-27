package com.example.calculatrice.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatriceExo2Service {


    public Integer addition(Integer a , Integer b){
        return a + b;
    }

    public Integer soustraction(Integer a , Integer b){
        return a - b;
    }

    public Integer multiplication(Integer a , Integer b){
        return a * b;
    }

    public Integer division(Integer a , Integer b){
        if (b != 0){
            return a / b;
        } else {
            return 0;
        }
    }

    public Integer modulo(Integer a , Integer b){
        return a % b;
    }
}
