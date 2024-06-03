package com.thanhnt.analysis.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class JobLauncherConfig {
    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JobLauncherConfig.class);
    /**
     * The file path.
     */
    @Value("${job.enabled-for}")
    public String jobEnabledFor;
    /**
     * The job launcher.
     */
    @Autowired
    JobLauncher jobLauncher;
    /**
     * The import analysisResult job.
     */
    @Autowired
    Job analysisResultJob;

    /**
     * Launch jobs.
     */
    @Scheduled(cron = "${cron.expression-value}")
    public void setJobLauncherJobs() {
        JobParameters parameters = new JobParametersBuilder()
                .addString("time", String.valueOf(System.currentTimeMillis())).toJobParameters();

        try {
            LOGGER.info("Job: launch export analysisResult to CSV ....");

            JobExecution analysisResultExecution = jobLauncher.run(analysisResultJob, parameters);
            LOGGER.info("Job: execution completed, status : {} ", analysisResultExecution.getExitStatus());
            LOGGER.info("Job: all job execution completed, status : {} ",
                    "All Jobs executed !!!...");

        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
                 | JobParametersInvalidException exception) {

            LOGGER.error("Exception message : {} ", exception.getMessage());
        }
    }
}
