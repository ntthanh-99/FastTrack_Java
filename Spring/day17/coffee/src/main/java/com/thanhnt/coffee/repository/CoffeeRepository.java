package com.thanhnt.coffee.repository;

import com.thanhnt.coffee.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
}
