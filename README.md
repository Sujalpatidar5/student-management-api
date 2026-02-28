# Student Management API

## Project Overview

This is a backend REST API project built using Spring Boot.

The purpose of this project is to manage student data using proper backend architecture and industry-level best practices.

This project demonstrates:

- REST API development
- Layered architecture (Controller → Service → Repository)
- DTO usage
- Input validation
- Global exception handling
- MySQL database integration
- Pagination
- Sorting
- Filtering
- Clean JSON responses

This project is built to strengthen backend fundamentals for full-stack development and placement preparation.

---

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman (for API testing)

---

## Project Architecture

The project follows layered architecture:

Controller Layer  
Handles HTTP requests and sends responses.

Service Layer  
Contains business logic and decision making.

Repository Layer  
Communicates with database using JPA.

DTO Layer  
Used to transfer data between client and server safely.

Entity Layer  
Represents database table structure.

Exception Layer  
Handles errors globally and returns structured JSON responses.

---

## Features Implemented

1. Add Student (POST)
2. Get Student By ID (GET)
3. Update Student (PUT)
4. Delete Student (DELETE)
5. Input Validation using @Valid
6. Global Exception Handling
7. Clean structured JSON error responses
8. DTO-based request and response structure
9. Pagination support
10. Sorting support
11. Filtering by name (contains search)

---

## API Endpoints

Base URL:
```
/students
```

### 1. Add Student
POST /students

### 2. Get Student By ID
GET /students/{id}

### 3. Update Student
PUT /students/{id}

### 4. Delete Student
DELETE /students/{id}

### 5. Get All Students (Pagination + Sorting + Filtering)

Example Requests:

Pagination:
```
GET /students?page=0&size=5
```

Sorting:
```
GET /students?page=0&size=5&sortBy=age&direction=desc
```

Filtering by name:
```
GET /students?name=ra&page=0&size=5
```

Combined:
```
GET /students?name=ra&page=0&size=5&sortBy=age&direction=asc
```

---

## Pagination

Pagination allows fetching data page by page instead of loading all records at once.

Response includes:

- data
- pageNumber
- pageSize
- totalElements
- totalPages
- last

Example Response:

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

## Sorting

Sorting allows ordering data by any field.

Parameters:

- sortBy (field name)
- direction (asc / desc)

Example:
```
GET /students?sortBy=name&direction=asc
```

---

## Filtering

Filtering allows searching students by name.

Current implementation:

- name contains search (LIKE %value%)

Example:
```
GET /students?name=ra
```

---

## Validation Handling

Validation is implemented using:

- @NotBlank
- @Email
- @NotNull
- @Min

If validation fails, the API returns structured JSON:

```json
{
  "status": 400,
  "errors": {
    "email": "Invalid email format",
    "name": "Name must not be blank"
  }
}
```

---

## Exception Handling

Two types of exceptions are handled:

1. StudentNotFoundException  
   When student ID does not exist.

2. Validation Exception  
   When input data is invalid.

GlobalExceptionHandler class handles all exceptions centrally.

---

## Why DTO is Used

DTO is used to:

- Hide internal entity structure
- Avoid exposing database fields directly
- Improve security
- Control input and output data
- Maintain clean architecture

---

## Database Configuration

Database used: MySQL

Configured in application.properties:

- Database URL
- Username
- Password
- Hibernate ddl-auto
- Show SQL queries

---

## What I Learned From This Project

- How Spring Boot manages objects using IoC
- How dependency injection works
- Difference between Entity and DTO
- How validation works internally
- How global exception handling works
- How pagination works using Pageable
- How sorting works using Sort
- How filtering works using method naming in JPA
- How to structure backend professionally

---

## Future Improvements

- Multiple filters (age, email)
- Dynamic filtering using Specification
- Swagger API documentation
- Logging using SLF4J
- Unit Testing
- Role-based authentication using Spring Security
- Docker containerization
- Deployment to cloud

---

## Pros of This Project

- Clean layered architecture
- Proper validation handling
- Structured error responses
- Pagination and sorting implemented
- Search functionality added
- Industry-level backend structure

---

## Limitations

- No authentication implemented yet
- Only single-field filtering implemented
- No unit testing
- No frontend integration

---

## Conclusion

This project demonstrates a production-style backend REST API using Spring Boot.

It includes CRUD operations, validation, exception handling, pagination, sorting, and filtering.

This project builds a strong foundation for developing real-world backend systems and full-stack applications.
