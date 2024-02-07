package com.example.springquartzwebclient.client.api.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.springquartzwebclient.client.api.BookerApiClient;
import com.example.springquartzwebclient.client.requests.AuthRequest;
import com.example.springquartzwebclient.client.responses.AuthResponse;
import com.example.springquartzwebclient.client.responses.BookingCompressedResponse;
import com.example.springquartzwebclient.client.responses.BookingResponse;

@Component
public class BookerApiService implements BookerApiClient {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BookerApiService.class);

    private final BookerApiClient bookerApiClient;

    public BookerApiService(final BookerApiClient bookerApiClient) {
        this.bookerApiClient = bookerApiClient;
    }

    @Override
    public AuthResponse authPost(AuthRequest request) {
        
        LOGGER.info("Authenticating user with username {}", request.getUsername());

        return this.bookerApiClient.authPost(request);
    }

    @Override
    public List<BookingCompressedResponse> bookingGet(final Map<String, String> headerValues,
            final Map<String, String> queryParams) {
        
        return this.bookerApiClient.bookingGet(headerValues, queryParams);
    }

    @Override
    public BookingResponse bookingBookingIdGet(final Map<String, String> headerValues, final Integer id) {

        return this.bookerApiClient.bookingBookingIdGet(headerValues, id);
    }

}
