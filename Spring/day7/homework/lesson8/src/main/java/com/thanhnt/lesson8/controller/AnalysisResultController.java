package com.thanhnt.lesson8.controller;

import com.thanhnt.lesson8.feignclient.PatientClient;
import com.thanhnt.lesson8.model.AnalysisResult;
import com.thanhnt.lesson8.model.Patient;
import com.thanhnt.lesson8.payload.response.AnalysisResultResponse;
import com.thanhnt.lesson8.service.AnalysisResultService;
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

    //@Autowired
    //PatientClient patientClient;

    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@RequestBody AnalysisResult analysisResult) {
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
        if (analysisResults != null && !analysisResults.isEmpty()) {
            for (AnalysisResult analysisResult : analysisResults) {
                //ResponseEntity<Patient> patientResponse = patientClient.findById(analysisResult.getCccd());
                analysisResultResponse = new AnalysisResultResponse();
                //.setPatient(patientResponse.getBody());
                analysisResultResponse.setAnalysisResult(analysisResult);
                response.add(analysisResultResponse);
            }
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.ok().body("Success: Don't exist analysis");
    }
}
