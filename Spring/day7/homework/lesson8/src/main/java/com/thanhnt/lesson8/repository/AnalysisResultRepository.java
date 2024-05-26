package com.thanhnt.lesson8.repository;

import com.thanhnt.lesson8.model.AnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnalysisResultRepository extends JpaRepository<AnalysisResult, Integer> {
    Optional<AnalysisResult> findById(Integer id);
}
