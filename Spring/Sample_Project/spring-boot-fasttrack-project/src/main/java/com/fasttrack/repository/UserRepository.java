package com.fasttrack.repository;

import com.fasttrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);

  boolean existsByEmail(String email);

  boolean existsByUsername(String username);

}
