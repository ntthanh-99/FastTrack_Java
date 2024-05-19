package com.thanhnt.analysis.controller;

import com.thanhnt.analysis.feignclient.PatientClient;
import com.thanhnt.analysis.model.AnalysisResult;
import com.thanhnt.analysis.model.Patient;
import com.thanhnt.analysis.payload.response.AnalysisResultResponse;
import com.thanhnt.analysis.service.AnalysisResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/analysis-result", produces = "application/json")
public class AnalysisResultController {
    @Autowired
    AnalysisResultService analysisResultService;

    @Autowired
    PatientClient patientClient;

    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@Valid @RequestBody AnalysisResult analysisResult) {
        AnalysisResult analysisResultSaved = analysisResultService.save(analysisResult);
        return ResponseEntity.ok().body("Success: AnalysisResult is created");
    }

    @RequestMapping("/get")
    public ResponseEntity<?> findById(@RequestParam("id") int id) throws Exception {
        AnalysisResult analysisResult = analysisResultService.findById(id);
        if (analysisResult != null) {
            return ResponseEntity.ok().body(analysisResult);
        }
        return ResponseEntity.badRequest().body("Error: Patient isn't exist!");
    }

    @RequestMapping("/all")
    public ResponseEntity<?> findAll() {
        List<AnalysisResultResponse> response = new ArrayList<>();
        AnalysisResultResponse analysisResultResponse = null;
        List<AnalysisResult> analysisResults = analysisResultService.findAll();
        if (analysisResults != null) {
            for(AnalysisResult analysisResult: analysisResults){
                ResponseEntity<Patient> patientResponse = patientClient.findById(analysisResult.getCccd());
                analysisResult.setPatient(patientResponse.getBody());
            }
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body("Error: Don't exist analysis");
    }
}
