package com.thanhnt.lesson8.payload.response;

import com.thanhnt.lesson8.model.AnalysisResult;
import com.thanhnt.lesson8.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisResultResponse {
    private AnalysisResult analysisResult;
    private Patient patient;
}
