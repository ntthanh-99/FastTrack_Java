package com.thanhnt.analysis.service;

import com.thanhnt.analysis.model.AnalysisResult;

import java.util.List;

// Proxy Pattern
public interface AnalysisResultService {
    List<AnalysisResult> findAll();
    AnalysisResult save(AnalysisResult analysisResult);
    AnalysisResult findById(Integer id);
}
