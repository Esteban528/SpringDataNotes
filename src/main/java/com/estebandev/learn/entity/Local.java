package com.estebandev.learn.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Local
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = { "manager", })
public class Local {
  @Id
  @SequenceGenerator(name = "local_secuence", sequenceName = "local_secuence", allocationSize = 1)
  @GeneratedValue(generator = "local_secuence", strategy = GenerationType.SEQUENCE)
  private Long localId;
  private String name;
  private String floor;

  /*
   * FetchType.LAZY Me trae todos los locales sin los manager
   * FetchType.EAGER Me trae todas los locales y sus relaciones
   */
  @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "manager_id", referencedColumnName = "managerId")
  private Manager manager;

  // NO ES RECOMENDABLE CONSULTAR MANY TO MANY CON FETCH EAGER
  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "local_customer_map", joinColumns = @JoinColumn(name = "local_id", referencedColumnName = "localId"), inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customerId"))
  private List<Customer> customerList;

  // One To Many
  // El fetch por defecto es Lazy
  // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  // @JoinColumn(name = "local_id", referencedColumnName = "localId")
  // List<Order> orderList;
}
