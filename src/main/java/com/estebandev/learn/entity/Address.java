package com.estebandev.learn.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Address
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
/*
 * @AttributeOverrides
 */
public class Address {

  private String customerCity;
  private String customerMainStreet;
  private String customerSecundaryStreet;
}
