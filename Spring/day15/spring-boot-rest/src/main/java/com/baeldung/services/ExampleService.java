package com.baeldung.services;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    public boolean fakeAuthenticate() {
        return true;
    }
}