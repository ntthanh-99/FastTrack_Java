package com.thanhnt.lesson8.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
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
     * Lanch jobs.
     */
    @Scheduled(cron = "${cron.expression-value}")
    public void setJobLauncherJobs() {
        //Map<String, JobParameter> maps = new HashMap<>();
        //maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters();

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
