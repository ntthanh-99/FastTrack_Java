package com.example.ssl_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@SpringBootApplication
public class SslDemoClientApplication {

	public static void main(String[] args) throws IOException {
		// System.setProperty("javax.net.ssl.trustStore", "src/main/resources/client_truststore.jks");
		System.setProperty("javax.net.ssl.trustStore", new ClassPathResource("client_truststore.jks").getFile().getAbsolutePath());
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		SpringApplication.run(SslDemoClientApplication.class, args);
	}

}
