package com.thanhnt.coffee.service.impl;

import com.thanhnt.coffee.model.Coffee;
import com.thanhnt.coffee.repository.CoffeeRepository;
import com.thanhnt.coffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Override
    public Coffee saveCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }
}
