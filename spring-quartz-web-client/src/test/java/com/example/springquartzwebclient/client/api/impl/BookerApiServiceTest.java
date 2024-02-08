package com.example.springquartzwebclient.client.api.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.springquartzwebclient.client.api.BookerApiClient;
import com.example.springquartzwebclient.client.requests.AuthRequest;
import com.example.springquartzwebclient.client.requests.BookingRequest;
import com.example.springquartzwebclient.client.responses.AuthResponse;
import com.example.springquartzwebclient.client.responses.BookingCompressedResponse;
import com.example.springquartzwebclient.client.responses.BookingResponse;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
class BookerApiServiceTest {

    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    @MockBean
    private BookerApiClient bookerApiClient;

    private BookerApiService bookerApiService;

    @BeforeEach
    void before() {
        bookerApiService = new BookerApiService(this.bookerApiClient);
    }

    @AfterEach
    void after() {
        verifyNoMoreInteractions(this.bookerApiClient);
    }

    @Test
    void authPost() {

        final AuthRequest request = PODAM_FACTORY.manufacturePojo(AuthRequest.class);
        final AuthResponse response = PODAM_FACTORY.manufacturePojo(AuthResponse.class);

        when(this.bookerApiClient.authPost(request)).thenReturn(response);

        final AuthResponse result = this.bookerApiService.authPost(request);

        assertEquals(response, result);

        verify(this.bookerApiClient).authPost(request);
    }

    @Test
    void bookingGet() {

        final Map<String, String> headerValues = PODAM_FACTORY.manufacturePojo(Map.class, String.class, String.class);
        final Map<String, String> queryParams = PODAM_FACTORY.manufacturePojo(Map.class, String.class, String.class);
        final List<BookingCompressedResponse> response = PODAM_FACTORY.manufacturePojo(List.class, BookingCompressedResponse.class);

        when(this.bookerApiClient.bookingGet(headerValues, queryParams)).thenReturn(response);

        final List<BookingCompressedResponse> result = this.bookerApiService.bookingGet(headerValues, queryParams);

        assertEquals(response, result);

        verify(this.bookerApiClient).bookingGet(headerValues, queryParams);
    }

    @Test
    void bookingBookingIdGet() {

        final Map<String, String> headerValues = PODAM_FACTORY.manufacturePojo(Map.class, String.class, String.class);
        final BookingResponse response = PODAM_FACTORY.manufacturePojo(BookingResponse.class);
        final Integer id = PODAM_FACTORY.manufacturePojo(Integer.class);

        when(this.bookerApiClient.bookingBookingIdGet(headerValues, id)).thenReturn(response);

        final BookingResponse result = this.bookerApiService.bookingBookingIdGet(headerValues, id);

        assertEquals(response, result);

        verify(this.bookerApiClient).bookingBookingIdGet(headerValues, id);
    }

    @Test
    void bookingPost() {

        final Map<String, String> headerValues = PODAM_FACTORY.manufacturePojo(Map.class, String.class, String.class);
        final BookingResponse response = PODAM_FACTORY.manufacturePojo(BookingResponse.class);
        final BookingRequest request = PODAM_FACTORY.manufacturePojo(BookingRequest.class);

        when(this.bookerApiClient.bookingPost(headerValues, request)).thenReturn(response);

        final BookingResponse result = this.bookerApiService.bookingPost(headerValues, request);

        assertEquals(response, result);

        verify(this.bookerApiClient).bookingPost(headerValues, request);
    }

    @Test
    void bookingBookingIdPut() {

        final Map<String, String> headerValues = PODAM_FACTORY.manufacturePojo(Map.class, String.class, String.class);
        final BookingResponse response = PODAM_FACTORY.manufacturePojo(BookingResponse.class);
        final Integer id = PODAM_FACTORY.manufacturePojo(Integer.class);
        final BookingRequest request = PODAM_FACTORY.manufacturePojo(BookingRequest.class);

        when(this.bookerApiClient.bookingBookingIdPut(headerValues, id, request)).thenReturn(response);

        final BookingResponse result = this.bookerApiService.bookingBookingIdPut(headerValues, id, request);

        assertEquals(response, result);

        verify(this.bookerApiClient).bookingBookingIdPut(headerValues, id, request);
    }

    @Test
    void bookingBookingIdDelete() {

        final Map<String, String> headerValues = PODAM_FACTORY.manufacturePojo(Map.class, String.class, String.class);
        final Integer id = PODAM_FACTORY.manufacturePojo(Integer.class);

        this.bookerApiService.bookingBookingIdDelete(headerValues, id);;

        verify(this.bookerApiClient).bookingBookingIdDelete(headerValues, id);
    }
    
}
