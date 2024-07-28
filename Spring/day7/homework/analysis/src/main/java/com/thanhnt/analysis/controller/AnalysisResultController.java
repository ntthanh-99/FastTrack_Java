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
    private final String requestId = UUID.randomUUID().toString();

    @Autowired
    AnalysisResultService analysisResultService;

    @Autowired
    PatientClient patientClient;

    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@Valid @RequestBody AnalysisResult analysisResult) {
        MDC.put("serviceId", serviceId);
        MDC.put("requestId", requestId);
        try {
            AnalysisResult analysisResultSaved = analysisResultService.save(analysisResult);
            return ResponseEntity.ok().body("Success: AnalysisResult is created");
        }finally {
            MDC.clear();
        }
    }

    @RequestMapping("/get")
    public ResponseEntity<?> findById(@RequestParam("id") int id) {
        MDC.put("serviceId", serviceId);
        MDC.put("requestId", requestId);
        try {
            AnalysisResult analysisResult = analysisResultService.findById(id);
            if (analysisResult != null) {
                return ResponseEntity.ok().body(analysisResult);
            }
            return ResponseEntity.badRequest().body("Error: Patient isn't exist!");
        } finally {
            MDC.clear();
        }
    }

    @RequestMapping("/all")
    public ResponseEntity<?> findAll() {
        MDC.put("serviceId", serviceId);
        MDC.put("requestId", requestId);
        try {
            log.info("AnalysisService/All");
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
            MDC.clear();
        }
    }
}
