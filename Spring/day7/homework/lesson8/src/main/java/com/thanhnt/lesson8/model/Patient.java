package com.thanhnt.lesson8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
