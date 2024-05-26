package com.thanhnt.lesson8.config;

import com.thanhnt.lesson8.model.AnalysisResult;
import com.thanhnt.lesson8.repository.AnalysisResultRepository;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.Writer;

/**
 * The Class UserAddressJob.
 * <p>
 * Class description explaining the usage.
 * </p>
 */
@Configuration
@EnableBatchProcessing
public class AnalysisResultJob {
    final String[] headers = new String[]{"id", "age", "birthday", "country", "email", "firstName", "gender", "lastName", "personId"};
    /**
     * The job builder factory.
     */
    @Autowired
    public JobBuilder jobBuilder;

    /**
     * The step builder factory.
     */
    @Autowired
    public StepBuilder stepBuilder;

    /**
     * The file path.
     */
    @Value("input")
    public String filePath;

    @Autowired
    AnalysisResultRepository analysisResultRepository;

    /**
     * Reader.
     *
     * @return Flat file item reader holds the
     */
    @Bean("analysisResultReader")
    public RepositoryItemReader<AnalysisResult> reader() {
        RepositoryItemReader<AnalysisResult> reader = new RepositoryItemReader<>();
        reader.setRepository(analysisResultRepository);
        reader.setMethodName("findAll");
        return reader;
    }
    /**
     * Writer.
     *
     * @return Jdbc batch item writer holds the
     */
    @Bean("analysisResulWriter")
    public FlatFileItemWriter<AnalysisResult> writer() {
        FlatFileItemWriter<AnalysisResult> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource("src/main/resources/analysisResult.csv"));
        writer.setAppendAllowed(true);
        writer.setLineAggregator(new DelimitedLineAggregator<>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<>() {
                    {
                        setNames(headers);
                    }
                });
            }
        });

        writer.setHeaderCallback(new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                for(int i=0;i<headers.length;i++){
                    if(i!=headers.length-1)
                        writer.append(headers[i] + ",");
                    else
                        writer.append(headers[i]);
                }
            }
        });
        return writer;
    }

    /**
     * Import Address job.
     *
     * @param listener the listener
     * @return Job holds the
     */
    /*@Bean("addressJob")
    public Job addressJob(JobListener listener) {
        return jobBuilder.get("addressJob").incrementer(new RunIdIncrementer()).listener(listener).flow(importData()).end().build();
    }*/


    /**
     * Import data.
     *
     * @return Step holds the
     */
    @Bean("AddressJobStep")
    public Step exportData() {
        return stepBuilder.get("AddressJobStep").<AnalysisResult, AnalysisResult>chunk(10).reader(reader()).processor(processor()).writer(writer()).build();
    }

}
