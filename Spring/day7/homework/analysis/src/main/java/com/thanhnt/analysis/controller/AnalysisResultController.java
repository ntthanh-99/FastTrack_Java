package com.thanhnt.analysis.controller;

import com.thanhnt.analysis.feignclient.PatientClient;
import com.thanhnt.analysis.model.AnalysisResult;
import com.thanhnt.analysis.model.Patient;
import com.thanhnt.analysis.payload.response.AnalysisResultResponse;
import com.thanhnt.analysis.payload.response.AnalysisResultResponseBuilder;
import com.thanhnt.analysis.service.AnalysisResultService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/analysis-result", produces = "application/json")
public class AnalysisResultController {
    private final String serviceId = "AnalysisResult";

    @Autowired
    AnalysisResultService analysisResultService;

    @Autowired
    PatientClient patientClient;

    @PostMapping("/register")
    public ResponseEntity<?> registerAnalysisResult(@Valid @RequestBody AnalysisResult analysisResult) {
        final String requestId = UUID.randomUUID().toString();
        MDC.put("serviceId", serviceId);
        MDC.put("requestId", requestId);
        MDC.put("patientId", analysisResult.getCccd());
        try {
            log.info("Register AnalysisResult For PatientId: {}", analysisResult.getCccd());
            AnalysisResult analysisResultSaved = analysisResultService.save(analysisResult);
            return ResponseEntity.ok().body("Success: AnalysisResult is created");
        }finally {
            log.info("Register AnalysisResult For PatientId: {} complete!!", analysisResult.getCccd());
            MDC.clear();
        }
    }

    @RequestMapping("/get")
    public ResponseEntity<?> findById(@RequestParam("id") int id) {
        final String requestId = UUID.randomUUID().toString();
        MDC.put("serviceId", serviceId);
        MDC.put("requestId", requestId);
        try {
            log.info("Find Analysis Result for Id: {}", id);
            AnalysisResult analysisResult = analysisResultService.findById(id);
            if (analysisResult != null) {
                return ResponseEntity.ok().body(analysisResult);
            }
            return ResponseEntity.badRequest().body("Error: Patient isn't exist!");
        } finally {
            log.info("Find Analysis Result for Id: {} complete!!", id);
            MDC.clear();
        }
    }

    @RequestMapping("/all")
    public ResponseEntity<?> findAll() {
        final String requestId = UUID.randomUUID().toString();
        MDC.put("serviceId", serviceId);
        MDC.put("requestId", requestId);
        try {
            log.info("Get All AnalysisResult !!");
            List<AnalysisResultResponse> response = new ArrayList<>();
            AnalysisResultResponse analysisResultResponse = null;
            List<AnalysisResult> analysisResults = analysisResultService.findAll();
            if (analysisResults != null && !analysisResults.isEmpty()) {
                for (AnalysisResult analysisResult : analysisResults) {
                    ResponseEntity<Patient> patientResponse = patientClient.findById(analysisResult.getCccd());
                    // Normal
                    //analysisResultResponse = new AnalysisResultResponse();
                    //analysisResultResponse.setPatient(patientResponse.getBody());
                    //analysisResultResponse.setAnalysisResult(analysisResult);

                    // Builder Pattern
                    analysisResultResponse = new AnalysisResultResponseBuilder()
                            .buildAnalysisResult(analysisResult)
                            .buildPatient(patientResponse.getBody())
                            .build();
                    response.add(analysisResultResponse);
                }
                return ResponseEntity.ok().body(response);
            }
            return ResponseEntity.ok().body("Success: Don't exist analysis");
        } finally {
            log.info("Get All AnalysisResult complete!!");
            MDC.clear();
        }
    }
}
