package io.zipcoder.crudapp;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class PersonController {
//
//    @Autowired
//    private final PersonRepository personRepository;
//
//    public PersonController(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    @PostMapping("/people")
//    public Person createPerson(Person p) {
//        return personRepository.save(p);
//    }
//
//    @GetMapping("/people/{id}")
//    public Person getPerson(@PathVariable int id) {
//        return personRepository.findOne(id);
//    }
//
//    @GetMapping("/people")
//    public List<Person> getPersonList() {
//        List<Person> outList =  new ArrayList<>();
//        for(Person p : personRepository.findAll()){
//            outList.add(p);
//        }
//        return outList;
//    }
//
//    @PutMapping("/people/{id}")
//    Person updatePerson(@PathVariable Integer id, Person p) {
//        Person holder = personRepository.findOne(id);
//        holder.setFirstName(p.firstName);
//        holder.setLastName(p.lastName);
//        return personRepository.save(holder);
//    }
//
//    @DeleteMapping("/people/{id}")
//    void DeletePerson(@PathVariable int id) {
//        personRepository.delete(id);
//    }
//}


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class PersonController {
    @Autowired
    public PersonRepository personRepository;
    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);
    }
    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
    }
    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }
    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable int id) {
        if (p.getId() != null) {
            return new ResponseEntity<>(personRepository.save(p), HttpStatus.OK);
        } else {
            return createPerson(p);
        }
    }
    @DeleteMapping("/people/{id}")
    public ResponseEntity DeletePerson(@PathVariable Long id){
        personRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}