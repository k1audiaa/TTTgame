[![Java CI with Gradle](https://github.com/k1audiaa/TTTgame/actions/workflows/gradle.yml/badge.svg)](https://github.com/k1audiaa/TTTgame/actions/workflows/gradle.yml)
# TicTacToe Game Backend

## Introduction

This project is a simple implementation of the classic Tic Tac Toe game. It includes a Spring Boot backend with user management.

## Features

- RESTful API for user management
- User points and level system
- Basic Tic Tac Toe game

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle
- Spring Web

## Getting Started

### Prerequisites

- Java 17
- PostgreSQL

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/k1audiaa/TTTgame
    ```

2. Set up PostgreSQL database:

    - Create a database named `tic_tac_toe`.
    - Update `application.yml` with your database configuration.

3. Run the application:

    ```bash
    ./gradlew bootRun
    ```

4. Access the API at [http://localhost:8080/api](http://localhost:8080/api)

## API Endpoints

- `GET /api/users`: Get the list of all users.
- `GET /api/users/{id}`: Get user details by ID.
- `GET /api/users/exists?username={username}`: Check if a user exists by username.
- `POST /api/users`: Create a new user.
- `PUT /api/users/{id}`: Update user details by ID.
- `PUT /api/users/{id}/updatePoints?points={points}`: Update user points and level by ID.
- `DELETE /api/users/{id}`: Delete a user by ID.

## Frontend 

You have to run the frontend separately from the backend. The frontend is a Vue.js application that consumes the RESTful API provided by the backend. Here is the link to the frontend repository: https://github.com/k1audiaa/TTTGame-Frontend

## Contributors

- [https://github.com/k1audiaa](https://github.com/k1audiaa)
- https://github.com/MeraGebreyes

## License

This project is licensed under the [MIT License](LICENSE).
