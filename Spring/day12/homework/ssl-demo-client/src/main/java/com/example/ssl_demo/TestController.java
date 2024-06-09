package com.example.ssl_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

  @GetMapping("/")
  public String readFromServer() {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject("https://localhost:8443/client", String.class);
  }
}
