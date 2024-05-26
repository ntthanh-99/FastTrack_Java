package com.thanhnt.lesson8.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class JobLauncherConfig.
 * <p>
 * Class description explaining the usage.
 * </p>
 */
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
    @Qualifier("analysisReportJob")
    Job empoyeeJob;

    /**
     * Lanch jobs.
     */
    @Scheduled(cron = "${cron.expression-value}")
    public void setJobLauncherJobs() {
        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);

        try {
            LOGGER.info("Launch job employee and address Data Import Job ....");

            if ("All".equalsIgnoreCase(jobEnabledFor) || "EMPLOYEE".equalsIgnoreCase(jobEnabledFor)) {
                JobExecution empoyeeJobExecution = jobLauncher.run(empoyeeJob, parameters);
                LOGGER.info("empoyeeJobExecution job execution completed, status : {} ", empoyeeJobExecution.getExitStatus());
            }
            LOGGER.info("All job execution completed, status : {} ",
                    "All Jobs executed !!!...");

        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
                 | JobParametersInvalidException exception) {

            LOGGER.error("Exception message : {} ", exception.getMessage());
        }
    }
}
