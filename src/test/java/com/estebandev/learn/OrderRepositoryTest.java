package com.estebandev.learn;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.estebandev.learn.entity.Local;
import com.estebandev.learn.entity.Order;
import com.estebandev.learn.repository.OrderRepository;

/**
 * OrderRepositoryTest
 */
@SpringBootTest
public class OrderRepositoryTest {

  @Autowired
  OrderRepository orderRepository;

  @Test
  void saveOrder() {
    Local local = Local.builder()
        .name("Binco")
        .floor("First Floor")
        .build();

    Order order = Order.builder()
        .description("camisa")
        .price(10.0)
        .local(local)
        .build();

    orderRepository.save(order);
  }

  @Test
  void findAllOrdersPaging() {
    Pageable firstPageWithThreeRecords = PageRequest.of(3, 3);
    List<Order> orderList = orderRepository.findAll(firstPageWithThreeRecords).getContent();
    System.out.println(orderList);

    long totalElements = orderRepository.findAll(firstPageWithThreeRecords).getTotalElements();
    int totalPages = orderRepository.findAll(firstPageWithThreeRecords).getTotalPages();
    System.out.println(totalElements);
    System.out.println(totalPages);
  }

  @Test
  void findAllOrdersWithSorting() {
    Pageable pageRequest = PageRequest.of(0, 3, Sort.by("price"));
    Pageable pageRequestDesc = PageRequest.of(0, 3, Sort.by("price").descending());
    List<Order> orderList = orderRepository.findAll(pageRequest).getContent();
    List<Order> orderListDesc = orderRepository.findAll(pageRequestDesc).getContent();

    System.out.println(orderList);
    System.out.println(orderListDesc);

  }

  @Test
  void findAllOrdersWithSearch() {
    Pageable pageable = PageRequest.of(0, 3);
    List<Order> orderList = orderRepository.findByDescriptionContaining("movie", pageable).getContent();
    System.out.println(orderList);
  }
}
