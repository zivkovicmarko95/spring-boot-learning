package com.example.springquartzwebclient.client.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import com.example.springquartzwebclient.client.requests.AuthRequest;
import com.example.springquartzwebclient.client.responses.AuthResponse;
import com.example.springquartzwebclient.client.responses.BookingCompressedResponse;
import com.example.springquartzwebclient.client.responses.BookingResponse;

public interface BookerApiClient {

    @PostExchange("https://restful-booker.herokuapp.com/auth")
    AuthResponse authPost(@RequestBody final AuthRequest request);

    @GetExchange("https://restful-booker.herokuapp.com/booking")
    List<BookingCompressedResponse> bookingGet(
            @RequestHeader final Map<String, String> headerValues,
            @RequestParam final Map<String, String> queryParams
    );

    @GetExchange("https://restful-booker.herokuapp.com/booking/{id}")
    BookingResponse bookingBookingIdGet(
            @RequestHeader final Map<String, String> headerValues,
            @PathVariable final Integer id
    );
    
}
