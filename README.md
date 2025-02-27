# Flight Booking System

## Overview
The **Flight Booking System** is a Spring Boot-based web application that allows users to book flights, manage their reservations, and handle user authentication seamlessly. The system provides an intuitive interface and robust backend services for a smooth booking experience.

## Features
- **User Authentication**
  - Signup
  - Login
- **Ticket Management**
  - Book a flight ticket
  - View booked tickets
  - Update ticket details (change flight date)
  - Cancel a booking

## Technologies Used
- **Backend:** Spring Boot
- **Database:** MySQL 
- **Security:** Spring Security
- **Build Tool:** Maven 
- **Other:**  REST API



## License
This project is open-source under the [MIT License](LICENSE).

## Contributors & Tasks

### ** Phase 1: Project Initialization & Architecture Design**
**Contributor:** *Sujal*  
✅ Define the project structure and architecture.  
✅ Design the database schema and entity relationships.  
✅ Set up the project repository and initial configurations.  

---

### ** Phase 2: Core Model Development**
- **User Model:** *Sreya Vijay*  
  ✅ Implement the `User` model with attributes like ID, name, email, password, role, etc.  
- **Booking Model:** *Jesny*  
  ✅ Implement the `Booking` model with attributes like booking ID, user ID (foreign key), booking date, status, etc.  

---

### ** Phase 3: Repository Implementation**
- **User Repository:** *Jahhhanvi*  
  ✅ Develop the `UserRepository` to handle database interactions for user CRUD operations.  
- **Booking Repository:** *Jesny*  
  ✅ Develop the `BookingRepository` for managing booking-related database transactions.  

---

### ** Phase 4: Controller Development & API Integration**
- **User Controller:** *Rahul*  
  ✅ Implement user-related APIs such as registration, authentication, and profile management.  
- **Booking Controller:** *Chris George*  
  ✅ Implement booking-related APIs for creation, retrieval, cancellation, and updates.  

---

### ** Phase 5: Integration & Testing**
**Contributor:** *Sujal*  
✅ Integrate all components (Models, Repositories, Controllers) and resolve dependencies.  
✅ Perform system testing and optimize database interactions.  
✅ Conduct API validation and debugging.  

**All Contributors:**  
✅ Perform unit testing for respective modules.  
✅ Ensure API endpoints function correctly.  

---

### ** Phase 6: Deployment & Final Review**
**Contributor:** *Sujal*  
✅ Prepare the final deployment setup and configuration.  
✅ Implement security best practices and performance optimizations.  
✅ Final review and documentation update.  






