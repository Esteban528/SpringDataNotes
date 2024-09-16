package com.estebandev.learn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Manager
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager {

  @Id
  @SequenceGenerator(name = "manager_generator", sequenceName = "manager_generator", allocationSize = 1)
  @GeneratedValue(generator = "manager_generator", strategy = GenerationType.SEQUENCE)
  private Long managerId;

  private String firstName;
  private String lastName;

  @OneToOne(mappedBy = "manager", fetch = FetchType.EAGER)
  private Local local;

}
