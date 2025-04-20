# 🏨 Smart Booking System (V1)

A microservice-based hotel booking platform built with Spring Boot and Clean Architecture principles.

---

## ✅ Features Implemented (V1)

### 🔧 Architecture & Stack
- Java 21 + Spring Boot 3.4.4
- Modular monorepo structure
- Clean Architecture (application/domain/infrastructure/web)
- Centralized configuration with Spring Cloud Config
- Service Discovery with Eureka
- PostgreSQL with Flyway migrations
- Dockerized services with Docker Compose
- Feign Clients for inter-service communication
- BaseEntity abstraction for timestamps
- Global Exception Handling with @ControllerAdvice
- REST endpoints with consistent `/api/v1/` pathing

### 🧩 Microservices
- **hotel-service**: Manages hotel and embedded room CRUD
- **reservation-service**: Handles reservations and status
- **search-service**: Syncs and stores denormalized data for querying
- **notification-service**: Kafka listener that sends email notifications based on reservation events

### 🔍 Search Service
- Denormalized `search_entries` table combining hotel, room, and reservation data
- Scheduled sync job every 12 hours (with manual trigger endpoint)
- Composite key deduplication using key hashing
- Dynamic filtering using JPA Specifications
- Default pagination, sorting, and fallback query params
- Clean DTOs, mapping, and logging structure
- Fully ready for Elasticsearch integration

### ⚙️ Observability & Maintenance
- SLF4J + Logback logging
- Flyway schema versioning (rename/migration examples included)
- Docker Compose orchestration
- Spring Boot Actuator for health checks

### 📡 Kafka Integration
- Kafka used for event-driven reservation updates
- `notification-service` listens to Kafka topic and is ready to send emails

---

## 🛠️ V2 Roadmap

| Feature                            | Description |
|------------------------------------|-------------|
| 🔍 Elasticsearch Integration       | Real-time search indexing & fuzzy matching |
| 🚀 Kafka-based indexing            | Replace scheduled sync with event-based sync |
| 🧠 CQRS                            | Separate read/write models in reservation flow |
| 📦 API Gateway + Security          | OAuth2 / Keycloak for authentication |
| 📊 Centralized Logging             | ELK or Loki integration |
| 📈 Metrics & Monitoring            | Prometheus + Grafana |
| 🧪 Testing Enhancements            | Testcontainers + Integration Tests |
| 🧾 Billing Module                  | Stripe integration for booking payments |
| 🌐 Geo Search                      | Hotel search with geo-distance filtering |
| 💬 i18n + Multi-language support   | Localization-ready frontend/backend |

---

## 🗂️ Folder Structure

smart-booking-system/
│
├── hotel-service/
├── reservation-service/
├── search-service/
├── notification-service/
├── common/
└── config-server/

## 📄 License

This project is licensed under the MIT License.