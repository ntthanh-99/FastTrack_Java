package com.thanhnt.analysis.repository;

import com.thanhnt.analysis.model.AnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnalysisResultRepository extends JpaRepository<AnalysisResult, Integer> {
    Optional<AnalysisResult> findById(Integer id);
}
