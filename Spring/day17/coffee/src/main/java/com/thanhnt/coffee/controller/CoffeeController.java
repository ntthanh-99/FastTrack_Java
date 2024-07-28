package com.thanhnt.coffee.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thanhnt.coffee.model.Coffee;
import com.thanhnt.coffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/coffee/getAll")
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    public ResponseEntity<String> getAll() {
        // request to other API
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.sampleapis.com/coffee/hot";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<?> result =
                restTemplate.exchange(uri, HttpMethod.GET, entity, List.class);

        // get response and save to DB
        List<Coffee> coffees = mapper.convertValue(result.getBody(), new TypeReference<List<Coffee>>() {});
        for(Coffee coffee : coffees){
            coffeeService.saveCoffee(coffee);
        }

        // return message
        return ResponseEntity.ok().body("Success: Save all coffees success!!");
    }
}
