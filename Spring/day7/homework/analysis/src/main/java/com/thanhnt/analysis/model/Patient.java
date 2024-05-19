package com.thanhnt.analysis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {
    /*
     * Identify of patient
     */
    private String cccd;

    /*
     * FullName of patient
     */
    private String patientName;

    /*
     * Date of birth
     */
    private String birthDate;

    /*
     * Gender
     * 1: Male
     * 0: Female
     */
    private int gender;

    /*
     * Address of patient
     */
    private String address;

    /*
     * phoneNum of patient
     */
    private String phoneNumber;
}
