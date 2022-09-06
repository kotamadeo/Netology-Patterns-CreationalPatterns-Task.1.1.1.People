package com.gmail.at.kotamadeo.model;

import com.gmail.at.kotamadeo.builder.PersonBuilder;

import java.util.Objects;
import java.util.Optional;

public class Person {
    private final String name;
    private final String surname;
    private byte age;
    private String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, byte age) {
        this(name, surname);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public Optional<Byte> getAge() {
        return Optional.of(age);
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            age++;
        }
    }

    public String getCity() {
        return city;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setCity(this.city);
    }

    public boolean hasCity() {
        return city != null;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Person that = (Person) o;
        return Objects.equals(this.name, that.name) && Objects.equals(this.surname, that.surname) &&
                Objects.equals(this.age, that.age) && Objects.equals(this.city, that.city);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
       return String.format("%s %s, %s. Город: %s.", surname, name, hasAge() ? age : "", hasCity() ? city : "");
    }
}
