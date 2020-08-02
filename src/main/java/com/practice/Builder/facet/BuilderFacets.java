package com.practice.Builder.facet;

class Person {
    // address
    public String streetAddress, postcode, city;

    // employment
    public String company, position;
    public int salary;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class PersonBuilder {
    public Person person = new Person();

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

    public Person build() {
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder {
    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder withStreetAddr(String streetAddr) {
        person.streetAddress = streetAddr;
        return this;
    }

    public PersonAddressBuilder withPostCode(String postCode) {
        person.postcode = postCode;
        return this;
    }

    public PersonAddressBuilder inCity(String city) {
        person.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonBuilder {
    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder inCompany(String company) {
        person.company = company;
        return this;
    }

    public PersonJobBuilder withPosition(String pos) {
        person.position = pos;
        return this;
    }

    public PersonJobBuilder withSalary(int salary) {
        person.salary = salary;
        return this;
    }
}

public class BuilderFacets {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person person = pb
            .lives()
                .inCity("San Francisco")
                .withPostCode("94587")
                .withStreetAddr("101 Union St")
            .works()
                .inCompany("Amazon")
                .withPosition("Engineer")
                .withSalary(150000)
                .build();
        System.out.println(person);
    }
}
