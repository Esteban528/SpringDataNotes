package com.estebandev.learn.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Order
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// Order = order es una palabra reservada de SQL
@Table(name = "tbl_order")
@ToString(exclude = "local")
public class Order {

  @Id
  @SequenceGenerator(name = "order_secuence", sequenceName = "order_secuence", allocationSize = 1)
  @GeneratedValue(generator = "order_secuence", strategy = GenerationType.IDENTITY)
  private Long orderId;
  private String description;
  private double price;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "local_id", referencedColumnName = "localId")
  private Local local;
}
