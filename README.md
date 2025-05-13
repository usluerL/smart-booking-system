# 🏨 Smart Booking System (V1)

A microservice-based hotel booking platform built with Spring Boot/Cloud and Clean Architecture principles.

---

## ✅ Features Implemented (V1)



### 🔧 Architecture & Stack
- Java 21 + Spring Boot 3.4.4
- Modular monorepo structure
- Clean Architecture (application/domain/infrastructure/web)
- Centralized configuration with Spring Cloud Config
- Service Discovery with Eureka
- PostgreSQL with Flyway migration scripts
- Dockerized services with Docker Compose
- Feign Clients for inter-service communication
- BaseEntity abstraction for auditing
- Global Exception Handling with @ControllerAdvice
- REST endpoints with consistent `/api/v1/` pathing

### 🧩 Microservices
- **hotel-service**: Manages hotel and embedded room CRUD
- **reservation-service**: Handles reservations and status, along with specific business rules/ use-cases
- **search-service**: Syncs and stores denormalized data for querying, criteria builder, dynamic filtering
- **notification-service**: Kafka listener that sends email notifications based on reservation events
- **composite-service (planned)**: Lays groundwork for API Composition pattern by aggregating data from hotel, room, and reservation services
- **Saga Pattern Ready (orchestration)**: Architecture supports eventual consistency workflows (e.g., distributed transaction boundaries in reservation flows)

### 🌐 API Gateway
- Spring Cloud Gateway used for centralized routing and filtering
- Path-based access routing for microservices
- Role-based access control per route
- JWT token validation and forwarding

### 📘 API Documentation
- Swagger / OpenAPI enabled via SpringDoc
- Docs available at `/swagger-ui.html` for all services

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

### 🔐 Security
- Keycloak integration for OAuth2 authentication
- Role-based access control with Spring Cloud Gateway
- JWT token parsing and validation using `realm_access.roles`
- Custom `JwtAuthenticationConverter` to extract roles from token
- Path-based access control (e.g., `/hotels/**` requires `ROLE_ADMIN`)
- Spring Security logs enabled for debugging authorization flow
- Postman automated token injection via scripting
---

### 🛠️ Infrastructure & CI/CD Enhancements
- Profile-based configuration loading (`local`, `dev`) with Git-backed config-server
- External Docker network (`booking-net`) for inter-service DNS resolution
- Optimized `app-compose.yml` and `infra-compose.yml` separation for flexible deployment
- Optimized Dockerfiles with multi-stage builds
- `.dockerignore` implemented for faster builds
- Unified `app-compose.yml` orchestrating all services
- Ready for GitHub Actions-based CI/CD pipeline
- Centralized build context cleanup and caching improvements

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