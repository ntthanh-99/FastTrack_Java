package com.thanhnt.patient.controller;

import com.thanhnt.patient.model.Patient;
import com.thanhnt.patient.service.PatientService;
import com.thanhnt.patient.util.Validation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/patient")
public class PatientController {
    private final String serviceId = "Patient";

    @Autowired
    PatientService patientService;

    @Autowired
    Validation validation;

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerPatient(@RequestBody Patient patient) {
        final String requestId = UUID.randomUUID().toString();
        MDC.put("serviceId", serviceId);
        MDC.put("requestId", requestId);
        MDC.put("patientId", patient.getCccd());
        try {
            log.info("registerPatient!!");
            if (patientService.findById(patient.getCccd()) != null) {
                return ResponseEntity.badRequest().body("Error: Patient is already existed!");
            }
            if (!validation.validatePatient(patient)) {
                return ResponseEntity.badRequest().body("Error: Information of patient isn't correct!");
            }
            Patient patientSaved = patientService.save(patient);
            return ResponseEntity.ok().body("Success: Patient is registered");
        } finally {
            MDC.clear();
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> findById(@RequestParam("cccd") String cccd) throws Exception {
        final String requestId = UUID.randomUUID().toString();
        MDC.put("serviceId", serviceId);
        MDC.put("requestId", requestId);
        MDC.put("patientId", cccd);
        try {
            log.info("findPatientByCCCD: {}", cccd);
            Patient patient = patientService.findById(cccd);
            if (patient != null) {
                return ResponseEntity.ok().body(patient);
            }
            return ResponseEntity.badRequest().body("Error: Patient isn't exist!");
        } finally {
            MDC.clear();
        }
    }
}
