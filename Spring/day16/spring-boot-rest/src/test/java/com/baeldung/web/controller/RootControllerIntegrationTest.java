package com.baeldung.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RootControllerIntegrationTest {

    private static final String ROOT_PATH = "/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenRead_thenStatusIsOk() throws Exception {
        this.mockMvc.perform(get(ROOT_PATH))
                .andExpect(status().isOk());
    }
}
