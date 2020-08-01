package com.udemy.Builder;

class Person
{
    public String name;

    public String position;

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder<SELF extends com.udemy.Builder.Facets.PersonBuilder<SELF>>
{
    protected com.udemy.Builder.Facets.Person person = new com.udemy.Builder.Facets.Person();

    // critical to return SELF here
    public SELF withName(String name)
    {
        person.name = name;
        return self();
    }

    protected SELF self()
    {
        // unchecked cast, but actually safe
        // proof: try sticking a non-PersonBuilder
        //        as SELF parameter; it won't work!
        return (SELF) this;
    }

    public com.udemy.Builder.Facets.Person build()
    {
        return person;
    }
}

class EmployeeBuilder
        extends com.udemy.Builder.Facets.PersonBuilder<EmployeeBuilder>
{
    public EmployeeBuilder worksAs(String position)
    {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self()
    {
        return this;
    }
}

public class RecursiveGenerics {
    public static void main(String[] args)
    {
        EmployeeBuilder eb = new EmployeeBuilder()
                .withName("Dmitri")
                .worksAs("Quantitative Analyst");
        System.out.println(eb.build());
    }
}