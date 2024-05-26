package com.thanhnt.lesson8.feignclient;

import com.thanhnt.lesson8.model.Patient;
import com.thanhnt.lesson8.util.Const;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Patient-service", url = Const.PATIENT_HOST, path = Const.PATIENT_PATH)
public interface PatientClient {
    @GetMapping("/get")
    ResponseEntity<Patient> findById(@RequestParam("cccd") String cccd);
}
