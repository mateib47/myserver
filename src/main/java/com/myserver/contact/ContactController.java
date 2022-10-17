package com.myserver.contact;

import com.myserver.person.PersonRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/contact")
@AllArgsConstructor
public class ContactController {
    private ContactService contactService;
//fix enable cors and make a proxy
    @CrossOrigin
    @PostMapping(path = "add")
    public String addContact(@RequestBody ContactRequest contactRequest){
        return contactService.addContact(contactRequest);
    }
}
