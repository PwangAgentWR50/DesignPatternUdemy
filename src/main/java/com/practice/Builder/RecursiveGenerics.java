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
        EmployeeBuilder pb = new EmployeeBuilder();
        Person doe = pb
                .withName("Doe")
                .worksAt("pos")
                // even EmployeeBuilder doesn't have worksAt() function
                // here .worksAt() [line 20] returns PersonBuilder, not EmployeeBuilder
                .build();

    }
}
