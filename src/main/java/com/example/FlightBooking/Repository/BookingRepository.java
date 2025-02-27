package com.example.FlightBooking.Repository;

import com.example.FlightBooking.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

public interface BookingRepository extends JpaRepository<Booking, Integer> {


    @Query(value = "SELECT b.*, u.name as username FROM booking b JOIN users u ON b.user_id = u.user_id WHERE b.user_id = ?1", nativeQuery = true)
    List<Map<String, Object>> viewMyTickets(int userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE booking SET ticket_class = ?2, date_of_journey = ?3 WHERE booking_id = ?1", nativeQuery = true)
    void updateBooking(int bookingId, String ticketClass, String dateOfJourney);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM booking WHERE booking_id = ?1", nativeQuery = true)
    void cancelBooking(int bookingId);
}
