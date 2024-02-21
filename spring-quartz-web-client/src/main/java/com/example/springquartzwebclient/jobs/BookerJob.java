package com.example.springquartzwebclient.jobs;

import java.util.List;
import java.util.Map;

import com.example.springquartzwebclient.client.api.impl.BookerApiService;
import com.example.springquartzwebclient.client.responses.BookingCompressedResponse;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookerJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookerJob.class);

    @Autowired
    private BookerApiService bookerApiService;

    @Override
    public void execute(final JobExecutionContext jobExecutionContext) throws JobExecutionException {
        
        LOGGER.info("Starting booker job");

        final List<BookingCompressedResponse> bookingCompressedResponse = this.bookerApiService.bookingGet(Map.of(), Map.of());

        LOGGER.info("List of booking comp {}", bookingCompressedResponse);

        LOGGER.info("Ended booker job ... OK");
    }
    
}
