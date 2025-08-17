# Benevolence Playground

Starter project to practice the Benevolence stack.
- Backend: Spring Boot 3 - Web + Data JPA
- Database: H2 in-memory by default. Optional PostgreSQL 16 via docker-compose.
- Frontend: Simple static page that calls the backend and shows users.
- Tests: Spock for backend, Cypress for frontend.
- CI: GitHub Actions for Maven build and tests.

## Prerequisites
- Java 17+
- Maven 3.9+
- Node 18+ and npm
- Optional: Docker Desktop for PostgreSQL

## Quick start - H2 mode
1. Backend
   ```bash
   cd backend
   mvn spring-boot:run
   ```
   - Hello API: http://localhost:8080/api/hello
   - Users API: GET http://localhost:8080/api/users, POST http://localhost:8080/api/users with JSON { "name": "Alice" }

2. Frontend
   ```bash
   cd ..
   npm install
   npm run serve
   ```
   - Open http://localhost:8081
   - Click Fetch Hello and Fetch Users or create a user

## Optional - PostgreSQL 16 with Docker
1. Create a `.env` file in repo root or edit the provided one.
2. Start DB:
   ```bash
   docker compose up -d
   ```
3. Run backend with postgres profile:
   ```bash
   cd backend
   mvn spring-boot:run -Dspring-boot.run.profiles=postgres
   ```

Default credentials are in `.env`. Never commit real secrets to public repos.

## Tests
- Backend:
  ```bash
  cd backend
  mvn test
  ```
- Frontend e2e:
  - Run backend and frontend first, then:
  ```bash
  cd ..
  npm run cypress:open
  ```

## CI
On push to main, GitHub Actions runs Maven verify in `backend`.

## Ethics reminder
Only use public docs and your own code. Do not forge logs, data, or results.
