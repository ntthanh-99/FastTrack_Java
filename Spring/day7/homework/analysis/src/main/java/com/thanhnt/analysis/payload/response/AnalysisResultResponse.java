package com.thanhnt.analysis.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisResultResponse {
    private String cccd;
    private String patientName;
    private String birthDate;
    private String gender;
    private String address;
    private String phoneNumber;
    private String analysisName;
    private String analysisType;
    private String analysisTimeStart;
    private String analysisTimeEnd;
    private String doctorName;
    private String evaluate;
    private String result;
}
