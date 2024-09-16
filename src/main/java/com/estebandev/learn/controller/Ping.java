package com.estebandev.learn.controller;

import org.springframework.web.bind.annotation.RestController;

import com.estebandev.learn.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Ping
 */
@RestController
@RequestMapping("/test")
public class Ping {

  @Autowired
  TestService testService;

  @GetMapping("/ping")
  public String pingPong() {
    return "Pong";
  }

}
