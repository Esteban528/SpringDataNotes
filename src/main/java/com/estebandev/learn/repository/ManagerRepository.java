package com.estebandev.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estebandev.learn.entity.Manager;

/**
 * ManagerRepository
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
