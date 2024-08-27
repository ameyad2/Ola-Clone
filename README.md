
# Ola Clone

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Technology Stack](#technology-stack)
- [Architecture](#architecture)
- [Contributing](#contributing)

## Introduction
The Ola Clone Full Stack is a Spring Boot application designed to replicate the core functionalities of the Ola cab booking service. It provides a robust backend infrastructure for managing cab bookings, user authentication, ride management, payments, and notifications. The project is built following SOLID principles, with a focus on scalability and maintainability. Frontend Module under development!

## Features
- **User Authentication**: Secure login and registration using JWT authentication.
- **Cab Management**: CRUD operations for managing cabs and their availability.
- **Ride Management**: Book, track, and cancel rides.
- **Role-Based Access Control**: Separate roles for users and admins.
- **Payment Integration**: Razorpay integration for handling payments.
- **Notification Service**: Twilio integration for sending SMS notifications.

## Installation
### Prerequisites
- Java 8+
- Maven
- MySQL
- Spring Security 6
- JWT Authentication
- Hibernate ORM
- Razorpay API
- Twilio
- RESTful APIs

### Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/ameyad2/Ola-Clone.git
    cd Ola-Clone
    ```
2. Set up the MySQL database:
    ```sql
    CREATE DATABASE ola_clone;
    ```
3. Update `application.properties` with your database and payment/notification configurations.
4. Build and run the application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Usage
- Access the API at `http://localhost:8080`.
- Use Postman or any other API client to interact with the endpoints.

## Technology Stack
- **Backend**: Spring Boot, Spring MVC, Hibernate, JWT Authentication, Spring Security 6
- **Database**: MySQL
- **Payment Integration**: Razorpay
- **Notification Service**: Twilio
- **Build Tool**: Maven
- **Programming Language**: Java 8
- **Principles**: SOLID Principles

## Architecture
### High-Level Design (HLD)
The high-level design of the Ola Clone application is based on a multi-tier architecture:

- **Frontend**: 
  - The frontend (to be implemented) will be developed using React.js to provide a responsive and user-friendly interface for users to interact with the system.
  - It will communicate with the backend through RESTful APIs.

- **Backend**:
  - The backend is developed using Spring Boot and handles all the business logic, data processing, and communication with the database.
  - It also manages authentication, authorization, and session management using Spring Security and JWT.

- **Database**:
  - MySQL is used as the relational database to store user information, cab details, booking records, and payment transactions.
  - The database is accessed using Hibernate ORM for efficient data management.

- **Payment Gateway**:
  - Razorpay is integrated into the backend to handle secure payments for cab bookings.

- **Notification Service**:
  - Twilio is used to send SMS notifications to users regarding booking confirmations, cancellations, and other updates.

### Low-Level Design (LLD)
The low-level design of the Ola Clone application focuses on the individual components and their interactions within the backend:

- **Controller Layer**:
  - **AuthenticationController**: Manages user registration, login, and JWT token generation.
  - **CabController**: Handles CRUD operations for managing cabs and their availability.
  - **RideController**: Manages booking, tracking, and cancellation of rides.
  - **PaymentController**: Integrates with Razorpay to process payments.
  - **NotificationController**: Integrates with Twilio to send SMS notifications.

- **Service Layer**:
  - **UserService**: Contains business logic for managing user-related operations, such as registration, login, and profile management.
  - **CabService**: Manages cab availability and assignment logic.
  - **RideService**: Implements ride booking, tracking, and cancellation logic.
  - **PaymentService**: Handles payment processing using Razorpay.
  - **NotificationService**: Manages the integration with Twilio for sending SMS notifications.

- **Repository Layer**:
  - **UserRepository**: Interfaces with the database to manage user data.
  - **CabRepository**: Handles data operations related to cabs.
  - **RideRepository**: Manages ride data in the database.

- **Entity Layer**:
  - Defines the data models for users, cabs, rides, and payments, and maps them to database tables using Hibernate.

- **Security Layer**:
  - Manages authentication and authorization using Spring Security and JWT.

## Contributing
Feel free to fork this repository, create feature branches, and submit pull requests. For significant changes, please open an issue to discuss your proposals.

## 🚀 About Me

## About Me

I am a full-stack developer with a strong focus on backend development. With over 2.5 years of experience in the industry, I have honed my skills in a wide range of backend technologies and frameworks. My expertise includes:

- **Spring Boot**: Building scalable and efficient backend applications.
- **Java**: Writing robust and maintainable code.
- **JPA-Hibernate**: Managing database interactions with ease.
- **Kafka**: Implementing reliable messaging and streaming systems.
- **Backend Development Architecture**: Designing and implementing reliable and scalable backend systems.
- **REST and SOAP Requests**: Developing and consuming APIs with precision.
- **Data Structures and Algorithms**: Solving complex problems with optimized solutions.
- **MySQL & IBM DB2**: Managing and querying relational databases effectively.
- **Additional Backend Technologies**: Experience with tools and platforms such as Docker, Kubernetes, Microservices architecture, and CI/CD pipelines.

My passion for backend development drives me to continuously learn and improve, ensuring that I stay updated with the latest trends and technologies in the field.


