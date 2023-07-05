package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findByUsername(String username);

    Person findById(int id);
}

