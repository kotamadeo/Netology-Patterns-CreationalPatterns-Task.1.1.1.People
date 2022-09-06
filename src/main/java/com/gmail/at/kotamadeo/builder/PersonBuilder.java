package com.gmail.at.kotamadeo.builder;

import com.gmail.at.kotamadeo.model.Person;

public class PersonBuilder {
    private String name;
    private String surname;
    private byte age;
    private String city;

    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустым!");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(byte age) {
        if (age <= 0) {
            throw new IllegalStateException("Возраст не может быть отрицательным!");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Отсутствует фамилия или имя!");
        }
        if (age <= 0) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }
        return person;
    }
}
