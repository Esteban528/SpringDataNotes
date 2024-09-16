package com.estebandev.learn.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Person
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

  @Id
  private int id;

  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String lastname;
  @Column(nullable = false)
  private int age;

}
