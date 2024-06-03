package com.thanhnt.analysis.batch.processor;

import com.thanhnt.analysis.model.AnalysisResult;
import org.springframework.batch.item.ItemProcessor;

public class AnalysisResultProcessor implements ItemProcessor<AnalysisResult, AnalysisResult> {

    @Override
    public AnalysisResult process(AnalysisResult item) throws Exception {
        return item;
    }
}
