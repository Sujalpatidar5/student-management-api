# Student Management API

## Project Overview

This is a backend REST API project built using Spring Boot.

The purpose of this project is to manage student data while following clean backend architecture and industry-level best practices.

This project demonstrates how a real backend system is designed with proper structure, security, and scalable design principles.

The project includes:

- REST API development
- Layered architecture (Controller → Service → Repository)
- DTO pattern
- Input validation
- Global exception handling
- MySQL database integration
- Pagination
- Sorting
- Filtering
- Authentication and Authorization
- JWT-based security
- Password encryption

This project was built for strengthening backend fundamentals for full-stack development and placement preparation.

---

# Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Spring Security
- JWT (JSON Web Token)
- MySQL
- Maven
- Postman (API testing)

---

# Project Architecture

The project follows Layered Architecture which is widely used in industry.

Controller Layer  
Handles HTTP requests and returns API responses.

Service Layer  
Contains business logic and processing rules.

Repository Layer  
Handles database communication using Spring Data JPA.

DTO Layer  
Transfers safe and controlled data between client and server.

Entity Layer  
Represents database table structure.

Security Layer  
Handles authentication, authorization, and request filtering.

Exception Layer  
Handles application errors globally.

---

# Features Implemented

## Student Management

1. Add Student (POST)
2. Get Student By ID (GET)
3. Update Student (PUT)
4. Delete Student (DELETE)
5. Pagination support
6. Sorting support
7. Filtering by name

---

# Input Validation

Validation implemented using:

- @NotBlank
- @Email
- @NotNull
- @Min

If validation fails, API returns structured JSON response.

---

# Global Exception Handling

Handled using:

`@ControllerAdvice`

Exceptions handled:

- StudentNotFoundException
- ValidationException

Example error response:

```json
{
  "status": 404,
  "message": "Student not found"
}
```

---

# Authentication and Security

Security is implemented using Spring Security and JWT Authentication.

The project supports:

- User registration
- User login
- Password encryption
- Role-based authorization
- JWT token authentication

---

# Password Encryption

Passwords are encrypted using:

`BCryptPasswordEncoder`

Example:

```
admin123
↓
$2a$10$sd8f7sdf8sd...
```

Passwords are never stored in plain text.

---

# User Roles

Two roles are implemented:

```
ADMIN
USER
```

Example authorization:

```
ADMIN → Can delete students
USER → Limited access
```

Role-based security is implemented using:

`@PreAuthorize`

---

# JWT Authentication

JWT is used for stateless authentication.

Authentication flow:

```
Client Login
↓
Server verifies username and password
↓
JWT Token generated
↓
Client stores token
↓
Client sends token in Authorization header
↓
JWT Filter verifies token
↓
Request allowed to access API
```

Example header:

```
Authorization: Bearer <JWT_TOKEN>
```

---

# API Endpoints

## Student APIs

Base URL

```
/students
```

### Add Student

```
POST /students
```

### Get Student By ID

```
GET /students/{id}
```

### Update Student

```
PUT /students/{id}
```

### Delete Student

```
DELETE /students/{id}
```

---

# Authentication APIs

## Register User

```
POST /auth/register
```

Example Request

```json
{
 "username": "rocky",
 "password": "rocky123",
 "role": "ADMIN"
}
```

---

## Login

```
POST /auth/login
```

Example Request

```json
{
 "username": "rocky",
 "password": "rocky123"
}
```

Response

```
JWT Token
```

---

# Pagination

Pagination allows retrieving data in small pages instead of loading all records at once.

Example:

```
GET /students?page=0&size=5
```

Response includes:

- data
- pageNumber
- pageSize
- totalElements
- totalPages
- last

Example response:

```json
{
  "data": [...],
  "pageNumber": 0,
  "pageSize": 5,
  "totalElements": 20,
  "totalPages": 4,
  "last": false
}
```

---

# Sorting

Sorting allows ordering records by any field.

Example:

```
GET /students?sortBy=name&direction=asc
```

---

# Filtering

Filtering allows searching students by name.

Example:

```
GET /students?name=ra
```

Implementation uses JPA query method:

```
findByNameContaining
```

---

# Security Flow

JWT security request flow:

```
Client Request
↓
JWT Authentication Filter
↓
Token Validation
↓
UserDetailsService
↓
SecurityContextHolder
↓
Controller Access
```

---

# Database Configuration

Database used:

```
MySQL
```

Configured in `application.properties`:

- Database URL
- Username
- Password
- Hibernate ddl-auto
- SQL logging

---

# What I Learned From This Project

- How Spring Boot manages objects using IoC
- How Dependency Injection works
- Difference between Entity and DTO
- How validation works internally
- How Global Exception Handling works
- How Pagination works using Pageable
- How Sorting works using Sort
- How Filtering works using JPA query methods
- How Spring Security works internally
- How password encryption works using BCrypt
- How JWT authentication works
- How request filters work in Spring Security

---

# Future Improvements

Possible future enhancements:

- Swagger API documentation
- Unit Testing using JUnit and Mockito
- Logging using SLF4J
- Docker containerization
- Deployment to cloud
- Dynamic filtering using Specifications
- Refresh token implementation

---

# Pros of This Project

- Clean layered architecture
- Proper validation handling
- Secure authentication system
- JWT-based authorization
- Structured error responses
- Pagination and sorting implemented
- Search functionality added
- Industry-level backend structure

---

# Limitations

- No frontend integration
- No automated unit testing
- Limited filtering fields
- Single microservice architecture

---

# Conclusion

This project demonstrates a secure and scalable backend REST API using Spring Boot and Spring Security.

It includes:

- CRUD operations
- Validation
- Global exception handling
- Pagination and sorting
- Filtering
- Role-based security
- JWT authentication

This project builds a strong foundation for developing real-world backend systems and full-stack applications.
