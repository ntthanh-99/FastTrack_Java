package com.thanhnt.lesson8.controller;

import com.thanhnt.lesson8.model.AnalysisResult;
import com.thanhnt.lesson8.payload.response.AnalysisResultResponse;
import com.thanhnt.lesson8.service.AnalysisResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Mono<?> registerPatient(@RequestBody AnalysisResult analysisResult) {
        AnalysisResult analysisResultSaved = analysisResultService.save(analysisResult);
        return Mono.just("Success: AnalysisResult is created");
    }

    @RequestMapping("/get")
    public Mono<?> findById(@RequestParam("id") int id) throws Exception {
        AnalysisResult analysisResult = analysisResultService.findById(id);
        if (analysisResult != null) {
            return Mono.just(analysisResult);
        }
        return Mono.just("Error: Patient isn't exist!");
    }

    @RequestMapping("/all")
    public Flux<?> findAll() {
        List<AnalysisResultResponse> response = new ArrayList<>();
        AnalysisResultResponse analysisResultResponse = null;
        List<AnalysisResult> analysisResults = analysisResultService.findAll();
        if (analysisResults != null && !analysisResults.isEmpty()) {
            for (AnalysisResult analysisResult : analysisResults) {
                //ResponseEntity<Patient> patientResponse = patientClient.findById(analysisResult.getCccd());
                analysisResultResponse = new AnalysisResultResponse();
                //analysisResultResponse.setPatient(patientResponse.getBody());
                analysisResultResponse.setAnalysisResult(analysisResult);
                response.add(analysisResultResponse);
            }
            return Flux.just(response);
        }
        return Flux.just("Success: Don't exist analysis");
    }
}
