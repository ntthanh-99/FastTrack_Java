package com.thanhnt.lesson8.processor;

import com.thanhnt.lesson8.model.AnalysisResult;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class AnalysisResultProcessor implements ItemProcessor<AnalysisResult, AnalysisResult> {

    @Override
    public AnalysisResult process(AnalysisResult item) throws Exception {
        return item;
    }
}
