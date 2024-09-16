package com.estebandev.learn;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.estebandev.learn.entity.Manager;
import com.estebandev.learn.repository.ManagerRepository;

/**
 * ManagerRepositoryTest
 */
@SpringBootTest
public class ManagerRepositoryTest {

  @Autowired
  private ManagerRepository managerRepository;

  @Test
  @Disabled
  void findAllManagers() {
    System.out.println("Managers!!!!!");
    List<Manager> managers = managerRepository.findAll();
    managers.forEach(System.out::println);
  }
}
