package com.myserver.person;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/person")
@AllArgsConstructor
public class PersonController {
    private PersonService personService;
}
