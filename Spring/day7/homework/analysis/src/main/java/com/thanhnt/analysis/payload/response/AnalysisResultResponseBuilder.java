package com.thanhnt.analysis.payload.response;

import com.thanhnt.analysis.model.AnalysisResult;
import com.thanhnt.analysis.model.Patient;

public class AnalysisResultResponseBuilder {
    private AnalysisResult analysisResult;
    private Patient patient;

    public AnalysisResultResponseBuilder buildAnalysisResult(AnalysisResult analysisResult){
        this.analysisResult = analysisResult;
        return this;
    }

    public AnalysisResultResponseBuilder buildPatient(Patient patient){
        this.patient = patient;
        return this;
    }

    public AnalysisResultResponse build(){
        return new AnalysisResultResponse(analysisResult, patient);
    }
}
