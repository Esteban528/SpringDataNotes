package com.estebandev.learn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customer_tbl", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email_address"))

public class Customer {
  @Id
  @SequenceGenerator(name = "customper_sequence", sequenceName = "customper_sequence", allocationSize = 10)
  @GeneratedValue(generator = "customper_sequence", strategy = GenerationType.IDENTITY)
  private Long customerId;

  private String firstName;
  private String lastName;

  @Column(name = "email_address", nullable = false)
  private String email;

  @Embedded
  Address address;
}
