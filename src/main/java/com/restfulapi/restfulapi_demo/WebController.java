package com.restfulapi.restfulapi_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebController {

    @Autowired
    private PersonEntitiyRepository personEntitiyRepository;

    // Code works without a constructer
    //public WebController(PersonEntitiyRepository personEntitiyRepository) 
    //{
    //    this.personEntitiyRepository = personEntitiyRepository;
    //}

    @GetMapping("/people")
    public List<Person> showPeople() 
    {
        // Retrieve the data from the "person" table
        return personEntitiyRepository.findAll();
    }

    /*
     * More endpoints can be added for CRUD operations.
     */
}
