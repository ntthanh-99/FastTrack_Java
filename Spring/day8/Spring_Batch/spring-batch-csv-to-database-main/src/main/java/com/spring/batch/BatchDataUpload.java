package com.spring.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class BatchDataUpload.
 * <p>
 * Using spring batch, data upload from csv to db.
 * </p>
 */

@SpringBootApplication
public class BatchDataUpload {

	public static void main(String[] args) {
		SpringApplication.run(BatchDataUpload.class, args);
	}

}
