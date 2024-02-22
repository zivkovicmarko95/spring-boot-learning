package com.example.springquartzwebclient.jobs;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.springquartzwebclient.client.api.impl.BookerApiService;
import com.example.springquartzwebclient.client.responses.BookingCompressedResponse;
import com.example.springquartzwebclient.client.responses.BookingResponse;

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

        final BookingCompressedResponse compressedResponse = bookingCompressedResponse.stream()
                .findAny()
                .orElseThrow();

        final BookingResponse bookingResponse = this.bookerApiService.bookingBookingIdGet(Map.of(), compressedResponse.getBookingid());

        LOGGER.info("Random booking response {} is found {}", compressedResponse, bookingResponse);

        LOGGER.info("Ended booker job ... OK");
    }
    
}
