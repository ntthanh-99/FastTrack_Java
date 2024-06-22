package com.baeldung.persistence.service;

import com.baeldung.persistence.IOperations;
import com.baeldung.persistence.model.Foo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFooService extends IOperations<Foo> {

    Page<Foo> findPaginated(Pageable pageable);

}
