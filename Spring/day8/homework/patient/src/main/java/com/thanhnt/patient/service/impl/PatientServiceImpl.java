package com.thanhnt.patient.service.impl;

import com.thanhnt.patient.model.Patient;
import com.thanhnt.patient.repository.PatientRepository;
import com.thanhnt.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient findById(String cccd) {
        Optional<Patient> patient = patientRepository.findById(cccd);
        return patient.isPresent() ? patient.get() : null;
    }

    @Override
    public List<Patient> findByPatientName(String patientName) {
        List<Patient> patients = patientRepository.findByPatientName(patientName);
        return patients;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }
}
