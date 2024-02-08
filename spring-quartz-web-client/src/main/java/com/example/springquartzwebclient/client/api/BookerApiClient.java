package com.example.springquartzwebclient.client.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.example.springquartzwebclient.client.requests.AuthRequest;
import com.example.springquartzwebclient.client.requests.BookingRequest;
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

    @PostExchange("https://restful-booker.herokuapp.com/booking")
    BookingResponse bookingPost(
            @RequestHeader final Map<String, String> headerValues,
            @RequestBody final BookingRequest requestBody
    );

    @PutExchange("https://restful-booker.herokuapp.com/booking/{id}")
    BookingResponse bookingBookingIdPut(
            @RequestHeader final Map<String, String> headerValues,
            @PathVariable final Integer id,
            @RequestBody final BookingRequest requestBody
    );

    @GetExchange("https://restful-booker.herokuapp.com/booking/{id}")
    void bookingBookingIdDelete(
            @RequestHeader final Map<String, String> headerValues,
            @PathVariable final Integer id
    );
    
}
