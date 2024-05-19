package com.thanhnt.analysis.feignclient;

import com.thanhnt.analysis.model.Patient;
import com.thanhnt.analysis.util.Const;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Patient-service", url = Const.PATIENT_HOST, path = Const.PATIENT_PATH)
public interface PatientClient {
    @GetMapping("/get")
    ResponseEntity<Patient> findById(@RequestParam("cccd") String cccd);
}
