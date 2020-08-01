package com.practice.Builder;

class Person {
    public String name;

    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder {
    protected Person person = new Person();

    public PersonBuilder withName(String name) {
        person.name = name;
        return this;
    }

    public Person build() {
        return person;
    }
}

class EmployeeBuilder extends PersonBuilder {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return this;
    }
}

public class RecursiveGenerics {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person doe = pb
                .withName("Doe")
                .worksAt("pos") // here worksAt function is not available
                .build();

    }
}
