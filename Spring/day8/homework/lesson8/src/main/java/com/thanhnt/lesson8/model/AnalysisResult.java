package com.thanhnt.lesson8.model;

import jakarta.persistence.*;
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
@Table(name = "analysis_result")
public class AnalysisResult {
    /*
     * Identify of analysis
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*
     * Identify of patient
     */
    @NotBlank
    private String cccd;

    /*
     * Patient
     */
    //private Patient patient;

    /*
     * Name of analysis
     */
    @NotBlank
    private String analysisName;

    /*
     * Type of analysis
     */
    @NotBlank
    private String analysisType;

    /*
     * Test start time of analysis
     */
    private String analysisTimeStart;

    /*
     * Test end time of analysis
     */
    private String analysisTimeEnd;

    /*
     * Doctor performed
     */
    @NotBlank
    private String doctorName;

    /*
     * Evaluate of doctor
     */
    private String evaluate;

    /*
     * Result
     */
    private String result;

    /*
     * Indicators of analysis
     */
    //private List<Indicator> indicators;

}
