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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "patient")
public class Patient {
    /*
     * Identify of patient
     */
    @Id
    @NotBlank
    private String cccd;

    /*
     * FullName of patient
     */
    @NotBlank
    private String patientName;

    /*
     * Date of birth
     */
    @NotBlank
    private String birthDate;

    /*
     * Gender
     * 1: Male
     * 0: Female
     */
    @NotBlank
    @Max(value = 1)
    @Min(value = 0)
    private int gender;

    /*
     * Address of patient
     */
    @NotBlank
    private String address;

    /*
     * phoneNum of patient
     */
    @NotBlank
    private String phoneNumber;
}
