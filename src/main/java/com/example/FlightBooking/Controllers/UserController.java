package com.example.FlightBooking.Controllers;

import com.example.FlightBooking.Models.Users;
import com.example.FlightBooking.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signUp")
    public ResponseEntity<Map<String, String>> signUp(@RequestBody Users u) {
        userRepository.save(u);
        Map<String, String> response = new HashMap<>();
        response.put("Status", "User Added Successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Users u) {
        List<Users> userObj = userRepository.validation(u.getEmail(), u.getPassword());
        Map<String, String> response = new HashMap<>();

        if (!userObj.isEmpty()) {
            Users user = userObj.get(0);
            response.put("Status", "Login Successful");
            response.put("UserId", String.valueOf(user.getUserId()));
            response.put("Name", user.getName());
        } else {
            response.put("Status", "Failed to Login");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/viewDetails")
    public ResponseEntity<Map<String, String>> viewDetails(@RequestBody Users u) {
        Users user = userRepository.viewDetails(u.getUserId());
        Map<String, String> response = new HashMap<>();

        if (user != null) {
            response.put("UserId", String.valueOf(user.getUserId()));
            response.put("Name", user.getName());
            response.put("Email", user.getEmail());
            response.put("PhoneNo", user.getPhone());
        } else {
            response.put("Status", "User Not Found");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<Map<String, String>> deleteUser(@RequestBody Users u) {
        userRepository.deleteUser(u.getUserId());
        Map<String, String> response = new HashMap<>();
        response.put("Status", "User Deleted Successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody Users u) {
        userRepository.updatePhoneNo(u.getUserId(), u.getPhone());
        Map<String, String> response = new HashMap<>();
        response.put("Status", "User Updated Successfully");
        return ResponseEntity.ok(response);
    }
}