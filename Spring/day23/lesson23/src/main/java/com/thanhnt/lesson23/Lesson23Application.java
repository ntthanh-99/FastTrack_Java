package com.thanhnt.lesson23;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lesson23Application {

	@Value("${aws.access.key}")
	private String AWS_ACCESS_KEY;

	@Value("${aws.secret.key}")
	private String AWS_SECRET_KEY;

	@Bean
	public AmazonS3 s3Client(){
		AWSCredentials credentials = new BasicAWSCredentials(
				AWS_ACCESS_KEY,
				AWS_SECRET_KEY
		);
		return AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.AP_SOUTHEAST_1)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Lesson23Application.class, args);
	}
}
