package com.baeldung.controllers;

import com.baeldung.SpringBootRestApplication;
import com.baeldung.requestresponsebody.ExamplePostController;
import com.baeldung.requestresponsebody.LoginForm;
import com.baeldung.services.ExampleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRestApplication.class)
public class ExamplePostControllerRequestIntegrationTest {

    private final String jsonBody = "{\"username\": \"username\", \"password\": \"password\"}";
    MockMvc mockMvc;
    @Mock
    private ExampleService exampleService;
    @InjectMocks
    private ExamplePostController exampleController;
    private LoginForm lf = new LoginForm();

    @Before
    public void preTest() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(exampleController)
                .build();
        lf.setPassword("password");
        lf.setUsername("username");
    }

    @Test
    public void requestBodyTest() {
        try {
            when(exampleService.fakeAuthenticate()).thenReturn(true);
            mockMvc
                    .perform(post("/post/request")
                            .content(jsonBody)
                            .contentType("application/json"))
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}