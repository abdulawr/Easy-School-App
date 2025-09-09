package com.basit.cz.easyschoolapp.repository;


import com.basit.cz.easyschoolapp.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findByEmail(String email);
}
