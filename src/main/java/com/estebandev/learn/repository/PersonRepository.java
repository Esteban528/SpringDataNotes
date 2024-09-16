package com.estebandev.learn.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.estebandev.learn.entity.Person;

/**
 * PersonRepository
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
