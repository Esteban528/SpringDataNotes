package com.estebandev.learn.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estebandev.learn.entity.Person;
import com.estebandev.learn.repository.PersonRepository;

/**
 * PersonService
 */
@Service
public class PersonService {

  @Autowired
  private PersonRepository personRepository;

  Logger logger = LoggerFactory.getLogger(PersonService.class);

  public void create(Person person) {
    logger.info("Create " + person);

    personRepository.save(person);
  }

  public void update(Person person) {
    logger.info("Create " + person);

    personRepository.save(person);
  }

  public List<Person> list() {
    return StreamSupport.stream(personRepository.findAll().spliterator(), false)
        .toList();
  }

}
