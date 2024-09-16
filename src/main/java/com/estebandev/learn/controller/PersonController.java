package com.estebandev.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estebandev.learn.entity.Person;
import com.estebandev.learn.service.PersonService;

/**
 * PersonController
 */
@RestController
@RequestMapping("/person")
public class PersonController {
  @Autowired
  private PersonService personService;

  @PostMapping
  public void createPerson(@RequestBody Person person) {
    personService.create(person);
  }

  @PutMapping
  public void updatePerson(@RequestBody Person person) {
    personService.update(person);
  }

  @GetMapping
  public List<Person> list() {
    return personService.list();
  }

  @DeleteMapping
  public String delete() {
    return "Hola";
  }

  // @GetMapping("/filterById")
  // public Person list(@RequestBody int id) {
  // return personService.get(id);
  // }
  //
  // @DeleteMapping
  // public void delete(@RequestBody Person person) {
  // personService.delete(person);
  // }
}
