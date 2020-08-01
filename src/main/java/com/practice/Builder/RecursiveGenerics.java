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

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withName(String name) {
        // here we cannot return PersonBuilder
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return this;
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

public class RecursiveGenerics {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person doe = pb
                .withName("Doe")
                .worksAt("engineer")
                .build();
        System.out.println(doe);
    }
}
