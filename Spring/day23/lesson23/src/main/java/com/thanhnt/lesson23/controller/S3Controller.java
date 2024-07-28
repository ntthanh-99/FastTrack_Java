package com.thanhnt.lesson23.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/s3")
@CrossOrigin(origins = "*", maxAge = 3600)
public class S3Controller {
    @Autowired
    AmazonS3 s3Client;

    @Value("${aws.s3.bucket.name}")
    private String BUCKET_NAME;

    @GetMapping("/bucket/all")
    public ResponseEntity<?> listAll(){
        List<Bucket> buckets = s3Client.listBuckets();

        // Display the bucket names
        //List<Bucket> buckets = listBucketsResponse.buckets();
        System.out.println("Buckets:");
        for (Bucket bucket : buckets) {
            System.out.println(bucket.getName());
        }
        return ResponseEntity.ok(buckets);
    }

    @GetMapping("/bucket/file/all")
    public ResponseEntity<?> fileAll(){
        ListObjectsV2Request request = new ListObjectsV2Request();
        request.setBucketName(BUCKET_NAME);

        ListObjectsV2Result response = s3Client.listObjectsV2(request);

        List<S3ObjectSummary> contents = response.getObjectSummaries();

        System.out.println("Number of objects in the bucket: " + contents.stream().count());
        contents.stream().forEach(System.out::println);

        return ResponseEntity.ok(contents);
    }

    @GetMapping("/bucket/file/upload")
    public ResponseEntity<?> update(){
        File file = new File(".\\ThanhNT103.txt");
        PutObjectRequest request = new PutObjectRequest(BUCKET_NAME, file.getName(), file);
        PutObjectResult response = s3Client.putObject(request);
        System.out.println(response);
        return ResponseEntity.ok(response);
    }

}
