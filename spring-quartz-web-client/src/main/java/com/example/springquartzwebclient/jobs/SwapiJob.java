package com.example.springquartzwebclient.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SwapiJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwapiJob.class);
    
    @Override
    public void execute(final JobExecutionContext jobExecutionContext) throws JobExecutionException {
        
        LOGGER.info("Starting swapi job");

        LOGGER.info("Ended swapi job ... OK");
    }

}
