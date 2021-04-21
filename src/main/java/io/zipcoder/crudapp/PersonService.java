package io.zipcoder.crudapp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//    @Service
//    public class PersonService {
//    private PersonRepository personRepository;
//
//    @Autowired
//    public PersonService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    public Person createPerson (Person person){
//        return personRepository.save(person);
//    }
//
////    public Person getPerson(Long id){
////        return personRepository.findById(id).get();
////    }
//
//    public List<Person> getPersonList (){
//        List<Person> personList = new ArrayList<>();
//        personRepository.findAll().forEach(personList::add);
//        return personList;
//    }
//
////    public Person updatePerson(Long id, Person person){
////        Person originalPerson = repository.findById(id).get();
////        originalPerson.setFirstName(newPersonData.getFirstName());
////
////    }
//
//        public Boolean delete (Long id){
//            repository.delete(id);
//            return true;
//        }
//}

import org.springframework.stereotype.Service;
@Service
public class PersonService {
    private PersonRepository repository;
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }
    public Iterable<Person> index() {
        return repository.findAll();
    }
    public Person show(Long id) {
        return repository.findOne(id);
    }
    public Person create(Person person) {
        return repository.save(person);
    }
    public Person update(Long id, Person newPersonData) {
        Person originalPerson = repository.findById(id).get();
        originalPerson.setFirstName(newPersonData.getFirstName());
        originalPerson.setLastName(newPersonData.getLastName());
        return repository.save(originalPerson);
    }
    public Boolean delete(Long id) {
        repository.delete(id);
        return true;
    }
}
