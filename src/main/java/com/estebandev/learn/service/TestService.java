package com.estebandev.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TestService
 */
@Service
public class TestService {

  public String getGreatter() {
    return "This a greater... Hello !!";
  }
}
