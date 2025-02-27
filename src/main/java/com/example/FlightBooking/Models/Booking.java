package com.example.FlightBooking.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int bookingId;

        @JsonProperty("userId")
        private int userId;

        @JsonProperty("source")
        private String source;

        @JsonProperty("destination")
        private String destination;

        @JsonProperty("ticketClass")
        private String ticketClass;

        @JsonProperty("airlineName")
        private String airlineName;

        @JsonProperty("flightNo")
        private String flightNo;

        @Temporal(TemporalType.DATE)
        @JsonProperty
        private Date dateOfJourney;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(updatable = false, nullable = false)
        private Date dateOfBooking = new Date();

        public Booking() {
        }

        public Booking(int bookingId, int userId, String source, String destination, String ticketClass, String airlineName, String flightNo, Date dateOfJourney, Date dateOfBooking) {
            this.bookingId = bookingId;
            this.userId = userId;
            this.source = source;
            this.destination = destination;
            this.ticketClass = ticketClass;
            this.airlineName = airlineName;
            this.flightNo = flightNo;
            this.dateOfJourney = dateOfJourney;
            this.dateOfBooking = dateOfBooking;
        }

        public int getBookingId() {
            return bookingId;
        }

        public void setBookingId(int bookingId) {
            this.bookingId = bookingId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getTicketClass() {
            return ticketClass;
        }

        public void setTicketClass(String ticketClass) {
            this.ticketClass = ticketClass;
        }

        public String getAirlineName() {
            return airlineName;
        }

        public void setAirlineName(String airlineName) {
            this.airlineName = airlineName;
        }

        public String getFlightNo() {
            return flightNo;
        }

        public void setFlightNo(String flightNo) {
            this.flightNo = flightNo;
        }

        public Date getDateOfJourney() {
            return dateOfJourney;
        }

        public void setDateOfJourney(Date dateOfJourney) {
            this.dateOfJourney = dateOfJourney;
        }

        public Date getDateOfBooking() {
            return dateOfBooking;
        }
}


