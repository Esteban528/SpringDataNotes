package com.estebandev.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estebandev.learn.entity.Local;

/**
 * LocalRepository
 */
@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {

}
