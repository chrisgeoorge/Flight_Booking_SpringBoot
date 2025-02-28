package com.example.FlightBooking.Repository;

import com.example.FlightBooking.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT * FROM users WHERE email = ?1 AND password = ?2", nativeQuery = true)
    List<Users> validation(String email, String password);

    @Query(value = "SELECT * FROM users WHERE user_id = ?1", nativeQuery = true)
    Users viewDetails(int userId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM users WHERE user_id = ?1", nativeQuery = true)
    void deleteUser(int userId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET phone_no = ?2 WHERE user_id = ?1", nativeQuery = true)
    void updatePhoneNo(int userId, String phoneNo);

    /*@Query(value = "SELECT u.user_id, u.name, u.email, u.phone_no, b.booking_id, b.flight_id, b.status " +
            "FROM users u LEFT JOIN bookings b ON u.user_id = b.user_id", nativeQuery = true)
    List<Object[]> getAllUsersWithBookings();*/
}
