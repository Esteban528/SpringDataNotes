package com.estebandev.learn;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.estebandev.learn.entity.Address;
import com.estebandev.learn.entity.Customer;
import com.estebandev.learn.entity.Local;
import com.estebandev.learn.entity.Manager;
import com.estebandev.learn.entity.Order;
import com.estebandev.learn.repository.LocalRepository;

/**
 * LocalRepositoryTest
 */
@SpringBootTest
public class LocalRepositoryTest {

  @Autowired
  private LocalRepository localRepository;

  @Test
  @Disabled
  void saveLocal() {
    Manager manager = Manager.builder()
        .firstName("Juan")
        .lastName("Perez")
        .build();

    Local local = Local.builder()
        .name("PetShop")
        .floor("Second Floor")
        .manager(manager)
        .build();

    localRepository.save(local);
  }

  @Test
  @Disabled
  void findAllLocals() {
    System.out.println("\n\n LIST OF LOCALS");
    List<Local> localList = localRepository.findAll();
    localList.forEach(System.out::println);

    System.out.println("\n\n -----------------");
  }

  @Test
  void saveLocalWithOrders() {
    Manager manager = Manager.builder()
        .firstName("Manuela")
        .lastName("Sanez")
        .build();
    Order order = Order.builder()
        .description("Movie place 1 2D")
        .price(15.6)
        .build();

    Order order2 = Order.builder()
        .description("Movie place 2 3D")
        .price(19.99)
        .build();

    Local local = Local.builder()
        .name("Cine")
        .floor("Third floor")
        // .orderList(List.of(order, order2))
        .manager(manager)
        .build();

    localRepository.save(local);
    System.out.println("Saving data");
  }

  @Test
  void findAllLocalsWithOrders() {
    List<Local> locals = localRepository.findAll();
    System.out.println(locals);
  }

  @Test
  void saveLocalWithCustomer() {
    Customer customer = Customer.builder()
        .firstName("Carl")
        .lastName("Jhonson")
        .email("jorge@nitales")
        .address(
            Address.builder().customerCity("Cali").customerMainStreet("Calle 18 N20-13")
                .customerSecundaryStreet("Cll 16 #13").build())
        .build();

    Customer customer2 = Customer.builder()
        .firstName("Pepo")
        .lastName("Nita")
        .email("pepo@nitales")
        .address(
            Address.builder().customerCity("Cali").customerMainStreet("Calle 18 N22-13")
                .customerSecundaryStreet("Cll 16 #23").build())
        .build();

    Local local = Local.builder()
        .name("Cluckin Bell")
        .floor("First Floor")
        .customerList(List.of(customer, customer2))
        .build();
    localRepository.save(local);
  }

  // Esto no es muy recomendable porque el fetch es eager
  @Test
  void findAllLocalsWithCustomers() {
    List<Local> locals = localRepository.findAll();
    System.out.println(locals);
  }

  @Test
  void findAllCustomersWithLocals() {
    Local local = localRepository.findById(31L).get();
    List<Customer> customers = local.getCustomerList();
    System.out.println(customers);
  }

}
