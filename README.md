# Event Ticket and Reservation API

A Spring Boot REST API for managing events, ticket availability, and bookings in a reservation system.

## Overview

This project provides a backend service for:
- Managing events
- Creating and retrieving bookings
- Searching events by venue
- Validating event and booking business rules
- Persisting data using MySQL

The application uses a standard layered architecture:
- Controller layer for REST endpoints
- Service layer for business logic
- Repository layer for database access
- Model layer for the domain entities

---

## Tech Stack

- Java 25
- Spring Boot 4.1.1
- Spring Web MVC
- Spring JDBC
- MySQL
- Maven

---

## Project Structure

```text
event-ticket-and-reservation-api/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── shadow/
│   │   │           └── eventticketandreservationapi/
│   │   │               ├── controller/
│   │   │               │   ├── EventController.java
│   │   │               │   └── BookingController.java
│   │   │               ├── model/
│   │   │               │   ├── Event.java
│   │   │               │   └── Booking.java
│   │   │               ├── repository/
│   │   │               │   ├── EventRepository.java
│   │   │               │   └── BookingRepository.java
│   │   │               ├── service/
│   │   │               │   ├── EventService.java
│   │   │               │   └── BookingService.java
│   │   │               └── EventTicketAndReservationApiApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .gitignore
├── .gitattributes
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── ...
```

---

## Features

### Event Management
- Get all active events
- Fetch event details by ID
- Search events by venue
- Create a new event
- Update an existing event
- Cancel/delete an event

### Booking Management
- Create a booking
- Get booking details by ID
- Cancel a booking

---

## API Endpoints

### Events

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/events` | Get all active events |
| GET | `/events/{id}` | Get event details by ID |
| GET | `/events/venue/{venue}` | Get events by venue |
| POST | `/events` | Create a new event |
| PUT | `/events/{id}` | Update an event |
| DELETE | `/events/{id}` | Cancel an event |

### Bookings

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/bookings` | Create a booking |
| GET | `/bookings/{id}` | Get booking details |
| DELETE | `/bookings/{id}` | Cancel a booking |

---

## Configuration

Application settings are stored in:

```properties
spring.application.name=EventTicketAndReservationAPI

spring.datasource.url=jdbc:mysql://172.21.240.1:3306/event_db
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD:root}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.sql.init.mode=always
```

### Database Setup
Make sure MySQL is installed and running, and that the `event_db` database exists.

Optional environment variable for DB password:

```bash
export DB_PASSWORD=your_password
```

---

## Prerequisites

Before running the project, ensure you have:

- Java 25
- Maven
- MySQL database server running

---

## Running the Application

From the project root, start the app with:

```bash
./mvnw spring-boot:run
```

The application starts on:

```text
http://localhost:8080
```

---

## Example Requests

### Create an Event
```bash
curl -X POST http://localhost:8080/events \
  -H "Content-Type: application/json" \
  -d '{
    "eventName": "Tech Conference 2026",
    "venue": "New York",
    "eventDate": "2026-12-15",
    "ticketPrice": 150.0,
    "availableSeats": 200
  }'
```

### Get All Active Events
```bash
curl http://localhost:8080/events
```

### Get Event by ID
```bash
curl http://localhost:8080/events/1
```

### Get Events by Venue
```bash
curl http://localhost:8080/events/venue/New%20York
```

### Create a Booking
```bash
curl -X POST http://localhost:8080/bookings \
  -H "Content-Type: application/json" \
  -d '{
    "eventId": 1,
    "customerName": "John Doe",
    "quantity": 2
  }'
```

### Get Booking by ID
```bash
curl http://localhost:8080/bookings/1
```

---

## Business Rules

The service layer validates:
- Event date must be in the future
- Ticket price cannot be negative
- Available seats must be greater than zero
- Event must exist before update or cancellation

---

## Notes

This project is focused on event booking and reservation workflows. It exposes a simple REST API and uses JDBC for persistence with MySQL.

---

## License

This project does not currently include a license file. If you plan to distribute or publish it publicly, consider adding an appropriate open-source license.
