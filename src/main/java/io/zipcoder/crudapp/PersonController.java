package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/people")
    Person createPerson(Person p) {
        return personRepository.save(p);
    }

    @GetMapping("/people/{id}")
    Person getPerson(int id) {
        return null;
    }

    @GetMapping("/people")
    List<Person> getPersonList() {
        List<Person> outList =  new ArrayList<>();
        for(Person p : personRepository.findAll()){
            outList.add(p);
        }
        return outList;
    }

    @PutMapping("/people/{id}")
    Person updatePerson(Person p) {
        Person holder = personRepository.findOne(p.getIdNumber());
        holder.setFirstName(p.firstName);
        holder.setLastName(p.lastName);
        return personRepository.save(holder);


    }

    @DeleteMapping("/people/{id}")
    void DeletePerson(int id) {
        personRepository.delete(id);
    }
}
