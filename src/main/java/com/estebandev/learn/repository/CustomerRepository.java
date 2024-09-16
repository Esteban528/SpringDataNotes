package com.estebandev.learn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estebandev.learn.entity.Customer;

import jakarta.transaction.Transactional;

/**
 * CustomerRepository
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  Optional<Customer> findByFirstName(String firstName);

  Optional<Customer> findByEmail(String email);

  List<Customer> findByFirstNameContaining(String firstName);

  List<Customer> findByLastNameNotNull();

  List<Customer> findByAddress_CustomerCity(String city);

  // JPQL
  @Query("select c from Customer c where c.email = ?1")
  Customer getCustomerByEmailAddress(String email);

  @Query("select c.firstName from Customer c where c.email = ?1")
  String getCustomerFirstNameByEmailAddress(String email);

  // Native queries
  @Query(value = "SELECT * FROM customer_tbl where email_address = ?1", nativeQuery = true)
  Customer getCustomerByEmailAddressNative(String email);

  @Query(value = "SELECT * FROM customer_tbl where email_address = :emilAddres", nativeQuery = true)
  Customer getCustomerByEmailAddressNativeNamedParams(@Param("emilAddres") String email);

  @Transactional
  @Modifying
  @Query("UPDATE Customer c SET c.firstName = :firstName WHERE c.email = :email")
  void updateCustomerFirstNameByEmail(@Param("firstName") String firstName, @Param("email") String email);
}
