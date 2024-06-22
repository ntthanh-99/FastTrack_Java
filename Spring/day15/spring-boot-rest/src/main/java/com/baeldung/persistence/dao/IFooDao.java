package com.baeldung.persistence.dao;

import com.baeldung.persistence.model.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFooDao extends JpaRepository<Foo, Long> {

}
