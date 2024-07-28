package com.thanhnt.patient.repository;

import com.thanhnt.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    Optional<Patient> findById(String cccd);

    List<Patient> findByPatientName(String patientName);
}
