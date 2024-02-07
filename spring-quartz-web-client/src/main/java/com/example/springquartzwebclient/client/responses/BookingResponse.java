package com.example.springquartzwebclient.client.responses;

import java.util.Date;
import java.util.Objects;

public class BookingResponse {
    
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public BookingResponse() {
    }

    public BookingResponse(final String firstname, final String lastname,
            final Integer totalprice, final Boolean depositpaid,
            final BookingDates bookingdates, final String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return this.totalprice;
    }

    public void setTotalprice(final Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean isDepositpaid() {
        return this.depositpaid;
    }

    public Boolean getDepositpaid() {
        return this.depositpaid;
    }

    public void setDepositpaid(final Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return this.bookingdates;
    }

    public void setBookingdates(final BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return this.additionalneeds;
    }

    public void setAdditionalneeds(final String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public BookingResponse firstname(final String firstname) {
        setFirstname(firstname);
        return this;
    }

    public BookingResponse lastname(final String lastname) {
        setLastname(lastname);
        return this;
    }

    public BookingResponse totalprice(final Integer totalprice) {
        setTotalprice(totalprice);
        return this;
    }

    public BookingResponse depositpaid(final Boolean depositpaid) {
        setDepositpaid(depositpaid);
        return this;
    }

    public BookingResponse bookingdates(final BookingDates bookingdates) {
        setBookingdates(bookingdates);
        return this;
    }

    public BookingResponse additionalneeds(final String additionalneeds) {
        setAdditionalneeds(additionalneeds);
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BookingResponse)) {
            return false;
        }
        BookingResponse bookingResponse = (BookingResponse) o;
        return Objects.equals(firstname, bookingResponse.firstname) &&
                Objects.equals(lastname, bookingResponse.lastname) &&
                Objects.equals(totalprice, bookingResponse.totalprice) &&
                Objects.equals(depositpaid, bookingResponse.depositpaid) &&
                Objects.equals(bookingdates, bookingResponse.bookingdates) &&
                Objects.equals(additionalneeds, bookingResponse.additionalneeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            firstname, lastname, totalprice, depositpaid, bookingdates, additionalneeds
        );
    }

    @Override
    public String toString() {
        return "{" +
            " firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", totalprice='" + getTotalprice() + "'" +
            ", depositpaid='" + isDepositpaid() + "'" +
            ", bookingdates='" + getBookingdates() + "'" +
            ", additionalneeds='" + getAdditionalneeds() + "'" +
            "}";
    }


    public static class BookingDates {

        private Date checkin;
        private Date checkout;

        public BookingDates() {
        }
    
        public BookingDates(final Date checkin, final Date checkout) {
            this.checkin = checkin;
            this.checkout = checkout;
        }
    
        public Date getCheckin() {
            return this.checkin;
        }
    
        public void setCheckin(final Date checkin) {
            this.checkin = checkin;
        }
    
        public Date getCheckout() {
            return this.checkout;
        }
    
        public void setCheckout(final Date checkout) {
            this.checkout = checkout;
        }
    
        public BookingDates checkin(final Date checkin) {
            setCheckin(checkin);
            return this;
        }
    
        public BookingDates checkout(final Date checkout) {
            setCheckout(checkout);
            return this;
        }
    
        @Override
        public boolean equals(final Object o) {
            if (o == this)
                return true;
            if (!(o instanceof BookingDates)) {
                return false;
            }
            BookingDates bookingDates = (BookingDates) o;
            return Objects.equals(checkin, bookingDates.checkin) &&
                    Objects.equals(checkout, bookingDates.checkout);
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(checkin, checkout);
        }
    
        @Override
        public String toString() {
            return "{" +
                " checkin='" + getCheckin() + "'" +
                ", checkout='" + getCheckout() + "'" +
                "}";
        }

    }

}
