# Microservices-Based linkedIn-backend

## Overview
This repository hosts a suite of microservices that collectively form a social networking platform akin to LinkedIn. Built using Spring Boot 3.2 and Java 21, the architecture employs a microservices approach for scalability, maintainability, and robustness.

## Microservices Description
- **Discovery Server (Port 8761)**: Implements Eureka for service discovery.
- **User Service (Port 8080)**: Manages user registration, authentication (with JWT and Spring Security), and CRUD operations.
- **Profile Service (Port 8081)**: Handles profiles, education, experience, and skills, and verifies user existence via User Service.
- **Post Service (Port 8082)**: Manages posts, comments, likes, and checks profile existence through Profile Service.
- **BFF Service (Backend For Frontend - Port 8084)**: Aggregates data from other services for frontend usage.

## Features
- Microservices architecture with Spring Boot and Java.
- Service discovery with Eureka.
- JWT-based authentication.
- Swagger UI integrated for API documentation.
- Docker support for containerization and easy deployment.
- PostgreSQL databases for each service.
- MapStruct for DTO and entity mapping.
- Lombok library for reducing boilerplate code.

## Quick Start
1. **Clone the Repository**
   ```
   git clone https://github.com/Karlmabs/linkedIn-backend.git
   ```

2. **Build the Project**
   Navigate to each service directory and run:
   ```
   mvn clean install
   ```

3. **Run with Docker Compose**
   From the root directory, run:
   ```
   docker-compose up
   ```

## Accessing Services
- **Swagger UI**: Available at `http://localhost:<port>/swagger-ui/index.html` for each service.
- **Eureka Dashboard**: `http://localhost:8761`
