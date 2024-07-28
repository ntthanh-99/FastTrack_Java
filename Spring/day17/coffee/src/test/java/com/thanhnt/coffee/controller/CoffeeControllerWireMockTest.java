package com.thanhnt.coffee.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.gson.Gson;
import com.thanhnt.coffee.model.Coffee;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoffeeControllerWireMockTest {
    private static final String API_PATH = "/coffee/hot";
    private static WireMockServer wireMock;
    private List<Coffee> coffees;

    @BeforeClass
    public static void startWireMock() {
        wireMock = new WireMockServer();
        configureFor("localhost", 8080);
        wireMock.start();
    }

    @AfterClass
    public static void stopWireMock() {
        wireMock.stop();
    }

    @BeforeEach
    public void createWireMockStub() {
        Coffee coffee = new Coffee();
        coffee.setId(1);
        coffee.setTitle("Ca phe den");
        coffee.setDescription("Ca phe nguyen chat, dam vi thom ngon");
        coffee.setImage("localhost:8080/image/1");
        coffee.setIngredients(new String[]{"Coffee"});
        coffees = new ArrayList<>();
        coffees.add(coffee);
        wireMock.stubFor(get(urlEqualTo(API_PATH)).willReturn(aResponse().withBody(new Gson().toJson(coffees)).withStatus(200)));
    }

    @Test
    void apiCallTest() throws IOException {
        HttpGet request = new HttpGet("http://localhost:8080" + API_PATH);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(request);
        response.getEntity().getContent();
        int statusCode = response.getCode();
        assertEquals(200, statusCode);
        InputStream content = response.getEntity().getContent();
        String body = getBody(content);
        assertEquals(body, new Gson().toJson(coffees));
    }

    public String getBody(InputStream input) {
        String result = new BufferedReader(new InputStreamReader(input))
                .lines().collect(Collectors.joining("\n"));
        return result;
    }
}
