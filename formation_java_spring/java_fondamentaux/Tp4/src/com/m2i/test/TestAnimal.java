package com.m2i.test;

import com.m2i.model.Animal;

public class TestAnimal {
    public void tester() {
        Animal a = new Animal("Tigre", 5, "Félin");
        System.out.println(a.nom);       // ✅ public → accessible
        // System.out.println(a.age);    // ❌ protected → inaccessible hors package sans héritage
        // System.out.println(a.espece); // ❌ private → inaccessible
    }
}