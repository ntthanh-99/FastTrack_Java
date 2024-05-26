package com.thanhnt.lesson8.batch.config;

import com.thanhnt.lesson8.batch.listener.JobListener;
import com.thanhnt.lesson8.batch.processor.AnalysisResultProcessor;
import com.thanhnt.lesson8.model.AnalysisResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

@Configuration
@EnableBatchProcessing
public class AnalysisResultJob {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(AnalysisResultJob.class);

    private static final String CSV_FILE = "output.csv";
    final String[] headers = new String[]{"ID", "CCCD", "AnalysisName", "analysisType", "analysisTimeStart", "analysisTimeEnd", "doctorName", "evaluate", "result"};

    @Autowired
    DataSource dataSource;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Bean
    public JdbcCursorItemReader<AnalysisResult> reader() {
        LOGGER.info("Initialize reader!");
        final String SQL = "SELECT * FROM analysis_result";
        JdbcCursorItemReader<AnalysisResult> reader = new JdbcCursorItemReader<>();
        reader.setSql(SQL);
        reader.setDataSource(dataSource);
        reader.setRowMapper(new BeanPropertyRowMapper<>(AnalysisResult.class));
        return reader;
    }

    @Bean()
    public AnalysisResultProcessor processor() {
        LOGGER.info("Initialize processor!");
        return new AnalysisResultProcessor();
    }

    @Bean()
    public FlatFileItemWriter<AnalysisResult> writer() {
        LOGGER.info("Initialize writer!");
        File file = new File(CSV_FILE);
        if (!file.exists()) {
            try {
                LOGGER.info("File not exist! Create new File!");
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FlatFileItemWriter<AnalysisResult> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource(CSV_FILE));
        writer.setAppendAllowed(true);

        writer.setHeaderCallback(new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.write("ID, CCCD, AnalysisName, analysisType, analysisTimeStart, analysisTimeEnd, doctorName, evaluate, result");
            }
        });

        writer.setLineAggregator(new DelimitedLineAggregator() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor() {
                    {
                        setNames(headers);
                    }
                });
            }
        });
        return writer;
    }

    @Bean("AnalysisResultJob")
    public Job analysisResulttJob(JobRepository jobRepository, JobListener listener) {
        return new JobBuilder("AnalysisResultJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(exportData(jobRepository))
                .build();
    }

    @Bean("AnalysisResultJobStep")
    public Step exportData(JobRepository jobRepository) {
        return new StepBuilder("AnalysisResultJobStep", jobRepository).<AnalysisResult, AnalysisResult>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
}
