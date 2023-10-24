package com.restfulapi.restfulapi_demo;

import org.springframework.stereotype.Service;
@Service
public class PersonService {

    public String retrivePersonName(Person person)
    {
        return person.getName();
    }

    public void setPersonName(Person person, String string)
    {
        person.setName(string);
    }

    public Person createNewPerson(String name, Integer age)
    {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }
}
