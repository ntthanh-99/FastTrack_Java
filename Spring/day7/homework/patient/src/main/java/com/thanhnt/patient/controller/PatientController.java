package com.thanhnt.patient.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thanhnt.patient.model.Patient;
import com.thanhnt.patient.service.PatientService;
import com.thanhnt.patient.util.Validation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/patient", produces = "application/json",
        consumes = "application/json;charset=UTF-8")
public class PatientController {
    @Autowired
    PatientService patientService;

    @Autowired
    Validation validation;

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerPatient(@RequestBody Patient patient) {
        if (patientService.findById(patient.getCccd()) != null) {
            return ResponseEntity.badRequest().body("Error: Patient is already existed!");
        }
        if (validation.validatePatient(patient)) {
            return ResponseEntity.badRequest().body("Error: Information of patient isn't correct!");
        }
        Patient patientSaved = patientService.save(patient);
        return ResponseEntity.ok().body("Success: Patient is registered");
    }

    @GetMapping("/get")
    public ResponseEntity<?> findById(@RequestParam("cccd") String cccd) throws Exception {
        Patient patient = patientService.findById(cccd);
        if (patient != null) {
            return ResponseEntity.ok().body(patient);
        }
        return ResponseEntity.badRequest().body("Error: Patient isn't exist!");
    }
}
