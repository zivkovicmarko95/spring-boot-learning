package com.example.springquartzwebclient.client.responses;
import java.util.Objects;

public class BookingCompressedResponse {
    
    private Integer bookingid;

    public BookingCompressedResponse() {
    }

    public BookingCompressedResponse(final Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Integer getBookingid() {
        return this.bookingid;
    }

    public void setBookingid(final Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingCompressedResponse bookingid(final Integer bookingid) {
        setBookingid(bookingid);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BookingCompressedResponse)) {
            return false;
        }
        BookingCompressedResponse bookingCompressed = (BookingCompressedResponse) o;
        return Objects.equals(bookingid, bookingCompressed.bookingid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingid);
    }

    @Override
    public String toString() {
        return "{" +
            " bookingid='" + getBookingid() + "'" +
            "}";
    }    

}
