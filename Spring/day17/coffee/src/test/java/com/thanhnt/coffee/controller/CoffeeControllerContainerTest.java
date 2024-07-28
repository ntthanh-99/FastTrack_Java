package com.thanhnt.coffee.controller;

import com.thanhnt.coffee.model.Coffee;
import com.thanhnt.coffee.repository.CoffeeRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoffeeControllerContainerTest {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres"
    );

    @Autowired
    private CoffeeRepository coffeeRepository;

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    @Transactional
    void saveCoffeeSuccessTest() {
        Coffee coffee = new Coffee();
        coffee.setId(100);
        coffee.setTitle("Ca phe den");
        coffee.setDescription("Ca phe nguyen chat, dam vi thom ngon");
        coffee.setImage("localhost:8080/image/1");
        coffee.setIngredients(new String[]{"Coffee"});
        List<Coffee> coffees = new ArrayList<>();
        coffees.add(coffee);

        for (Coffee c : coffees) {
            Coffee savedCoffee = coffeeRepository.save(c);
            assertEquals(c, savedCoffee);
        }
    }
}
