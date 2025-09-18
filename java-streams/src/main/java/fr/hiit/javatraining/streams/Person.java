package fr.hiit.javatraining.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private String nationality;
}