package com.thanhnt.lesson8.service.impl;

import com.thanhnt.lesson8.model.AnalysisResult;
import com.thanhnt.lesson8.repository.AnalysisResultRepository;
import com.thanhnt.lesson8.service.AnalysisResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalysisResultServiceImpl implements AnalysisResultService {
    @Autowired
    AnalysisResultRepository analysisResultRepository;

    @Override
    public List<AnalysisResult> findAll() {
        return analysisResultRepository.findAll();
    }

    @Override
    public AnalysisResult save(AnalysisResult analysisResult) {
        return analysisResultRepository.save(analysisResult);
    }

    @Override
    public AnalysisResult findById(Integer id) {
        Optional<AnalysisResult> analysisResult = analysisResultRepository.findById(id);
        return analysisResult.isPresent() ? analysisResult.get() : null;
    }
}
