package com.restfulapi.restfulapi_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebController {
    private final PersonService personService;
    Person person = new Person();

    public WebController(PersonService personService) 
    {
        this.personService = personService;
    }

    @GetMapping("/")
    public String HTTP_Request_getPersonName() 
    {
        return this.setHTMLPage(personService.retrivePersonName(person));
    }

    @GetMapping("/setNameAsAli")
    public String HTTP_Request_setPersonName()
    {
        personService.setPersonName(person, "Ali");
        return setNameHTMLInfo("Ali");
    }
    
    public String setHTMLPage(String string) 
    {
        return "<!DOCTYPE html>\r\n"                                + //
                "<html>\r\n"                                        + //
                "    <head>\r\n"                                    + //
                "        <h3>Example</h3>\r\n"                      + //
                "    </head>\r\n"                                   + //
                "    <body>\r\n"                                    + //
                "        <p>Name is now : " + string + " - (Go to "  + //
                "<a href="+"http://localhost:8080/setNameAsAli"+">here)</a></p>\r\n" + //
                "    </body>\r\n"                                   + //
                "</html>";
    }

    public String setNameHTMLInfo(String string)
    {
        return "<!DOCTYPE html>\r\n"                                + //
                "<html>\r\n"                                        + //
                "    <body>\r\n"                                    + //
                "        <p>Name is set as " + string + " - (Go back to "+//
                "<a href="+"http://localhost:8080/"+">here)</a></p>\r\n"    + //
                "    </body>\r\n"                                   + //
                "</html>";
    }
}
