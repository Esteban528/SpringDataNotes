package com.estebandev.learn;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.estebandev.learn.entity.Address;
import com.estebandev.learn.entity.Customer;
import com.estebandev.learn.repository.CustomerRepository;

/**
 * CustomerRepositoryTest
 */
@SpringBootTest
public class CustomerRepositoryTest {
  @Autowired
  CustomerRepository customerRepository;

  @Test
  @Disabled
  void saveCustomer() {
    Customer customer = Customer.builder()
        .firstName("Jon")
        .lastName("doe")
        .build();
    customerRepository.save(customer);
  }

  @Test
  @Disabled
  void saveCustomerWithAddressEmbedded() {
    int r = (int) (Math.random() * 10);
    String email = r + "@pu.com";
    if (customerRepository.findByEmail(email).isEmpty()) {
      Customer customer = Customer.builder()
          .firstName("Jorge")
          .lastName("Nitales Bedoya")
          .email(email)
          .address(
              Address.builder().customerCity("Cali").customerMainStreet("Calle 18 N20-13")
                  .customerSecundaryStreet("Cll 16 #13").build())
          .build();
      customerRepository.save(customer);
    }
  }

  @Test
  void findCustomerByFirstName() {
    Customer customer = customerRepository.findByFirstName("Pepo").get();
    System.out.println(customer);
  }

  @Test
  void findAllCustomers() {
    System.out.println("\n\n LIST OF CUSTOMERS");
    List<Customer> customersList = customerRepository.findAll();
    customersList.forEach(System.out::println);

    System.out.println("\n\n -----------------");
  }

  @Test
  void findAllCustomersFirstNameContaining() {
    System.out.println("\n\n LIST OF findAllCustomersFirstNameContaining");
    List<Customer> customersList = customerRepository.findByFirstNameContaining("Jo");

    customersList.forEach(System.out::println);

    System.out.println("\n\n -----------------");
  }

  @Test
  void findAllCustomersLastNameNotNull() {
    System.out.println("\n\n LIST OF findAllCustomersLastNameNotNull");
    List<Customer> customersList = customerRepository.findByLastNameNotNull();

    customersList.forEach(System.out::println);

    System.out.println("\n\n -----------------");
  }

  @Test
  void findAllCustomersByAddressCity() {
    System.out.println("\n\n LIST OF findAllCustomersByAddressCity");
    List<Customer> customersList = customerRepository.findByAddress_CustomerCity("Cali");

    customersList.forEach(System.out::println);

    System.out.println("\n\n -----------------");
  }

  @Test
  void findCustomerByEmailAddress() {
    System.out.println("\n\n findCustomerByEmailAddress");
    Customer customer = customerRepository.getCustomerByEmailAddress("pepito@google.com");

    System.out.println(customer);
    System.out.println("\n\n -----------------");
  }

  @Test
  void getCostumerFirstNameByEmailAddress() {
    System.out.println("\n\n getCostumerFirstNameByEmailAddress");
    String customerFirstName = customerRepository.getCustomerFirstNameByEmailAddress("pepito@google.com");

    System.out.println(customerFirstName);
    System.out.println("\n\n -----------------");
  }

  @Test
  void findCustomerByEmailAddressNative() {
    System.out.println("\n\n findCustomerByEmailAddressNative");
    Customer customer = customerRepository.getCustomerByEmailAddressNative("pepito@google.com");

    System.out.println(customer);
    System.out.println("\n\n -----------------");
  }

  @Test
  void findCustomerByEmailAddressNativeNamedParams() {
    System.out.println("\n\n findCustomerByEmailAddressNativeNamedParams");
    Customer customer = customerRepository.getCustomerByEmailAddressNativeNamedParams("pepito@google.com");

    System.out.println(customer);
    System.out.println("\n\n -----------------");
  }

  @Test
  void updateCustomerFirstNameByEmail() {
    System.out.println("\n\n updateCustomerFirstNameByEmail");
    customerRepository.updateCustomerFirstNameByEmail("Pepo", "pepito@google.com");
  }
}
