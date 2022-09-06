package com.gmail.at.kotamadeo;

import com.gmail.at.kotamadeo.builder.PersonBuilder;
import com.gmail.at.kotamadeo.model.Person;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder().setName("Анна").setSurname("Вольф").setAge((byte) 31).setCity("Сидней").build();
        Person son = mom.newChildBuilder().setName("Антошка").build();
        System.out.println("У " + mom + " есть сын, " + son);
        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        try {
            new PersonBuilder().setAge((byte) -100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}