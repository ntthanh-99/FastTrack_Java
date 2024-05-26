package com.thanhnt.lesson8.service;

import com.thanhnt.lesson8.model.AnalysisResult;

import java.util.List;

public interface AnalysisResultService {
    List<AnalysisResult> findAll();
    AnalysisResult save(AnalysisResult analysisResult);
    AnalysisResult findById(Integer id);
}
