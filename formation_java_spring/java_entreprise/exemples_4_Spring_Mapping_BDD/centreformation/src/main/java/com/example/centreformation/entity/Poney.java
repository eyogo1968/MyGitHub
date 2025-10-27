package com.example.centreformation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "poney")
public class Poney {

    @Id
    @GeneratedValue
    private Long id;
}
