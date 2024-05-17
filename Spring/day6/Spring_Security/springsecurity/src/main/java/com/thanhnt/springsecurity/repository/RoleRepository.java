package com.thanhnt.springsecurity.repository;

import java.util.Optional;

import com.thanhnt.springsecurity.model.ERole;
import com.thanhnt.springsecurity.model.Role;
import com.thanhnt.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
