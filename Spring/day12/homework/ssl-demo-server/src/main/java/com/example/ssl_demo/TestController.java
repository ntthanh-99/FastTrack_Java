package com.example.ssl_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @GetMapping("/")
  public String hello() {
    return "Hello, SSL!";
  }

  @GetMapping("/client")
  public String client() {
    return "You have successfully configured SSL for your Java Application!";
  }
}
