package com.restfulapi.restfulapi_demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfulapi.CustomResponseEntity;


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

    @PostMapping("/savePerson")
    public Person savePerson(@RequestBody Person person)
    {
        person.setName(person.getName());
        person.setSurname(person.getSurname());

        return personEntitiyRepository.save(person);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<String> putPerson(@PathVariable Long id, @RequestBody Person updatedPerson)
    {
        // Check if the person with the given ID exists in the database
        Optional<Person> existingPersonOptional = personEntitiyRepository.findById(id);

        if (existingPersonOptional.isEmpty()) 
        {
            // If the person does not exist, return a 404 Not Found response
            return CustomResponseEntity.notFound("404 NOT FOUND!");
        }
        
        // Get the existing person
        Person existingPerson = existingPersonOptional.get();
        
        // Update the existing person with the data from the request
        existingPerson.setName(updatedPerson.getName());
        existingPerson.setSurname(updatedPerson.getSurname());
        
        // Save the updated person to the repository
        personEntitiyRepository.save(existingPerson);
        
        // Return the updated person in the response
        return CustomResponseEntity.ok("UPDATE is OK!");
    }

    /*
     * More endpoints can be added for CRUD operations.
     */
}
