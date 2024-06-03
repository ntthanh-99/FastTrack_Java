package com.thanhnt.analysis.payload.response;

import com.thanhnt.analysis.model.AnalysisResult;
import com.thanhnt.analysis.model.Patient;
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
