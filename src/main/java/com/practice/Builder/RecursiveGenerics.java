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
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    protected SELF self() {
        return (SELF)this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder workAt(String position) {
        this.person.position = position;
        return self();
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
                .withName("dow")
                .workAt("engineer")
                .build();
        System.out.println(doe);
    }
}
