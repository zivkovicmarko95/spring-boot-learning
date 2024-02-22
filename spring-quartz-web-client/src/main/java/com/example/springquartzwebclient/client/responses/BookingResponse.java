package com.example.springquartzwebclient.client.responses;

import java.util.Objects;

public class BookingResponse {
    
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private String additionalneeds;

    public BookingResponse() {
    }

    public BookingResponse(final String firstname, final String lastname,
            final Integer totalprice, final Boolean depositpaid,
            final String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
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
                Objects.equals(additionalneeds, bookingResponse.additionalneeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            firstname, lastname, totalprice, depositpaid, additionalneeds
        );
    }

    @Override
    public String toString() {
        return "{" +
            " firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", totalprice='" + getTotalprice() + "'" +
            ", depositpaid='" + isDepositpaid() + "'" +
            ", additionalneeds='" + getAdditionalneeds() + "'" +
            "}";
    }

}
