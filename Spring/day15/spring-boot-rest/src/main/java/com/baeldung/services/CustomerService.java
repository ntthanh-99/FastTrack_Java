package com.baeldung.services;

import com.baeldung.persistence.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> allCustomers();

    Customer getCustomerDetail(final String id);

}
