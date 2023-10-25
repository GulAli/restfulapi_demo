package com.restfulapi.restfulapi_demo;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public String getPersonName(Person person)
    {
        return person.getName();
    }

    public void setPersonName(Person person, String string)
    {
        person.setName(string);
    }
}
