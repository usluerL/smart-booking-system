# 🏨 Smart Booking System

A modular microservices-based hotel booking platform built with Java and Spring Boot.

---

## 📦 Modules

| Module              | Description                          |
|---------------------|--------------------------------------|
| `hotel-service`     | Manages hotel data and CRUD operations |
| `common`            | Shared components (DTOs, exceptions, base entities) |
| `reservation-service` _(planned)_ | Will handle reservations and messaging |
| `notification-service` _(planned)_ | Will handle notifications via Kafka |

---

## ⚙️ Tech Stack

- Java 21
- Spring Boot 3
- Spring Data JPA (with PostgreSQL / H2)
- RESTful API
- Docker + Docker Compose (planned)
- Kafka (planned)
- JWT Authentication (planned)
- Clean Architecture Principles ✅
- Manual DTO Mappers (MapStruct removed) ✅

---

## ✅ Features Implemented

- Multi-module Maven project structure
- Base auditing entity (`createdAt`, `updatedAt`)
- Global exception handling using `@ControllerAdvice`
- Custom domain exceptions per service
- Manual mapping layer (`HotelMapper`)
- Postman Collection support

---

## 🚧 Upcoming

- Room management under `hotel-service`
- `reservation-service` with Kafka producer integration
- `notification-service` with Kafka consumer
- JWT authentication with API Gateway
- Docker support and complete environment orchestration

---

## 🧠 Architecture

The project follows Clean Architecture principles:
- Clear separation between domain, application, and infrastructure
- Each service owns its own domain logic and exceptions
- Reusable structures (like error response) live in the `common` module

---

## 📂 Getting Started (dev only)

```bash
cd smart-booking-system
./mvnw clean install
cd hotel-service
./mvnw spring-boot:run