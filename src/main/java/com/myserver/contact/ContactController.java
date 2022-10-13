package com.myserver.contact;

import com.myserver.person.PersonRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/contact")
@AllArgsConstructor
public class ContactController {
    private ContactService contactService;

    @PostMapping(path = "add")
    public String addContact(@RequestBody ContactRequest contactRequest){
        return contactService.addContact(contactRequest);
    }
}
