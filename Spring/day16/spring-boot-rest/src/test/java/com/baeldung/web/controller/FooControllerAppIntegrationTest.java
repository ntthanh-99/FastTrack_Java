package com.baeldung.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import com.baeldung.persistence.dao.IFooDao;
import com.baeldung.persistence.service.IFooService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * We'll start the whole context, but not the server. We'll mock the REST calls instead.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FooControllerAppIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IFooDao fooDao;

    @MockBean
    private ApplicationEventPublisher eventPublisher;

    @Mock
    private IFooService service;

    private String FOOS_ENDPOINT = "/foos";

    @Before
    public void setup() {
        this.fooDao.deleteAll();
    }

    @Test
    public void whenFindPaginatedRequest_thenEmptyResponse() throws Exception {
        this.mockMvc.perform(get("/foos")
          .param("page", "0")
          .param("size", "2")
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().json("[]"));
    }

    @Test
    public void whenFindPaginatedRequest_thenThrowException() throws Exception {
        this.mockMvc.perform(get("/foos")
                        .param("page", "10")
                        .param("size", "2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void whenFindByIdWithCustomEtag_ThenReturnFoo() throws Exception {
        this.mockMvc.perform(get(FOOS_ENDPOINT +"/" + 1L +"/custom-etag"))
                .andExpect(status().isOk());

    }

    @Test
    public void whenFindById_ThenReturnFoo() throws Exception {
        this.mockMvc.perform(get(FOOS_ENDPOINT +"/" + 1L))
                .andExpect(status().isOk());

    }

    @Test
    public void whenFindAll_ThenReturnListFoo() throws Exception {
        this.mockMvc.perform(get(FOOS_ENDPOINT))
                .andExpect(status().isOk());

    }

    @Test
    public void whenFindPaginatedWithPageable_thenEmptyResponse() throws Exception {
        this.mockMvc.perform(get(FOOS_ENDPOINT +"/pageable")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void whenDeleteById_thenReturnOK() throws Exception {
        this.mockMvc.perform(delete(FOOS_ENDPOINT + "/" + 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
