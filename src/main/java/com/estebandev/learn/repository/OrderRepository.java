package com.estebandev.learn.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estebandev.learn.entity.Order;
import java.util.List;

/**
 * OrderRepository
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  Page<Order> findByDescriptionContaining(String description, Pageable pageable);
}
