package com.example.FlightBooking.Controllers;

import com.example.FlightBooking.Models.Booking;
import com.example.FlightBooking.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/book-ticket")
    public ResponseEntity<Map<String, String>> bookTicket(@RequestBody Booking booking){
        Booking bookingObj = bookingRepository.save(booking);
        Map<String, String> response = new HashMap<>();
        if (bookingObj.getId() != 0){
            response.put("Status", "Ticket Booked Successfully");
        }
        else {
            response.put("Status", "Ticket Booking Failed");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/view-my-tickets")
    public ResponseEntity<List<Map<String, String>>> viewMyBooking(@RequestBody Booking booking){
        List<Map<String, String>> bookingObj = bookingRepository.viewMyTickets(booking.getUserId());
        return ResponseEntity.ok(bookingObj);
    }

    @PostMapping("/update-ticket")
    public ResponseEntity<Map<String, String>> updateBooking(@RequestBody Booking booking){
        try{
            bookingRepository.updateBooking(booking.bookingId, booking.ticketClass, booking.dateOfJourney);
            Map<String, String> response = new HashMap<>();
            response.put("Status", "Ticket Updated Successfully");
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("Status", "Ticket Updation Unsuccessful"));
        }
    }

    @DeleteMapping("/cancel-ticket")
    public ResponseEntity<Map<String, String>> cancelBooking(@RequestBody Booking booking){
        try{
            bookingRepository.cancelBooking(booking.userId);
            return ResponseEntity.ok(Map.of("Status", "Ticket Cancelled Successfully"));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("Status", "Ticket Cancellation Unsuccessful"));
        }
    }
}
