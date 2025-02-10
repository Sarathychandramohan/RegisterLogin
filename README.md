# Login and Register Page

## Overview

This project is a **Login and Register Page** built using Java in a **Dynamic Web Project** (Eclipse). It allows users to register with their details and log in securely.

## Features

- User Registration with basic details
- Secure Login authentication
- Data stored using HashMap (instead of a database for simplicity)
- Tested using Postman

## Technologies Used

- **Java**
- **Eclipse IDE**
- **Tomcat Server**
- **Postman (for API testing)**

## Project Structure

```
Login/
|-- src/
|   |-- main/
|   |   |-- java/
|   |   |   |-- RegisterLogin/
|   |   |   |   |-- Register.java
|   |   |   |   |-- Login.java
|   |-- webapp/
|   |   |-- META-INF/
|   |   |-- WEB-INF/
|   |   |   |-- lib/
|   |   |   |   |-- jakarta.servlet-api-4.0.4.jar
|   |   |   |   |-- json-20250107.jar
|-- build/
|-- README.md
```

## Setup Instructions

1. Clone the repository:

   git clone https://github.com/Sarathychandramohan/RegisterLogin.git

2. Open **Eclipse** and import the project as an **Existing Project into Workspace**.
3. Configure **Tomcat Server** in Eclipse.
4. Run the project on the server.
5. Use **Postman** to test login and register endpoints.Use POST to request and gets response in console

## API Endpoints

### Register User

**Endpoint:** `POST /register`

- **Request Body (JSON)**:
  ```json
  {
    "username": "testuser",
    "password": "password123"
  }
  ```
- **Response:**
  ```json
  {
    "username": "testuser",
    "password": "password123"
  }
  ```
- **Error Response:**
  ```json
  {
    "Error": "Error message here"
  }
  ```

### Login User

**Endpoint:** `POST /login`

- **Request Body (JSON)**:
  ```json
  {
    "username": "testuser",
    "password": "password123"
  }
  ```
- **Successful Response:**
  ```json
  {
    "username": "testuser",
    "password": "password123"
  }
  ```
- **Error Response (Invalid Credentials):**
  ```json
  {
    "error": "Invalid Username or Password. Try again"
  }
  ```
- **Error Response (Other Issues):**
  ```json
  {
    "error": "Error message here"
  }
  ```

## Future Enhancements

- Add database integration (MySQL or PostgreSQL)
- Improve frontend with Bootstrap or React

## Author

**Sarathychandramohan**\
GitHub: [Sarathychandramohan](https://github.com/Sarathychandramohan)

