package com.thanhnt.patient.service;

import com.thanhnt.patient.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PatientService {
    Patient findById(String cccd);

    List<Patient> findByPatientName(String patientName);

    Patient save(Patient patient);
}
