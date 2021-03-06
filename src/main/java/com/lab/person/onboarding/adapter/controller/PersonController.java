package com.lab.person.onboarding.adapter.controller;

import com.lab.person.onboarding.adapter.controller.base.IPersonController;
import com.lab.person.onboarding.infrastructure.entity.PersonEntity;
import com.lab.person.onboarding.infrastructure.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController implements IPersonController {

    PersonService personService;

    PersonController(PersonService personService){
        this.personService = personService;
    }

    @Override
    public List<PersonEntity> getAll()  {
        return personService.getAllPersons();
    }

    @Override
    public PersonEntity getPersonById(String document) {
        return personService.getPerson(document).get();
    }

    @Override
    public PersonEntity postPerson(@RequestBody PersonEntity personEntity) {
        return personService.insertPerson(personEntity);
    }

    @Override
    public PersonEntity updatePerson(PersonEntity personEntity) {
        return personService.insertPerson(personEntity);
    }

    @Override
    public ResponseEntity<Object> deletePerson(String document) {
        personService.deletePerson(document);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
