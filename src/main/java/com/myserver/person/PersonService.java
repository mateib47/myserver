package com.myserver.person;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public Long addPerson(PersonRequest personRequest) {
        Person person = new Person(personRequest.getFirstName(),
                personRequest.getLastName(),
                personRequest.getStatus(),
                personRequest.getAttributes(),
                personRequest.getDescription(),
                personRequest.getBoldedWords(),
                personRequest.getEmail(),
                personRequest.getGithub(),
                personRequest.getLinkedin(),
                personRequest.getWords(),
                personRequest.getProfileImgLink());
        personRepository.save(person);
        return person.getId();
    }
}
