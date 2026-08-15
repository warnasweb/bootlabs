# Spring Boot E2 Labs — Java 21

A two-week, instructor-led lab series for experienced Java developers. The course builds a production-style Book Catalog API while exposing the Spring container, auto-configuration, persistence, cross-cutting concerns, API design, documentation, and testing strategy.

## Technical baseline

- Java 21
- Spring Boot 4.1.0 / Spring Framework 7
- Maven 3.6.3+
- H2 for fast local labs; MySQL 8.4 for production-like persistence
- JUnit 5, Mockito, MockMvc, Testcontainers, Awaitility
- springdoc-openapi for Swagger UI

Spring Boot 4.1 requires Java 17 or newer and supports Java 21. See the [official system requirements](https://docs.spring.io/spring-boot/system-requirements.html).

## Repository map

| Path | Purpose |
|---|---|
| `labs/day-01` … `labs/day-10` | Facilitated lab sheets, checkpoints, extensions, and review questions |
| `starter` | Compilable starting point used on Day 1 |
| `solution` | Complete reference implementation accumulated across all labs |
| `infrastructure` | MySQL container setup |
| `.github/workflows` | Java 21 build and test automation |

## Two-week journey

| Day | Theme | Main output |
|---:|---|---|
| 1 | Boot foundations and IDE workflow | Runnable application and context test |
| 2 | Container, components, Maven, embedded server | Layered in-memory feature |
| 3 | Configuration and annotations | Validated, profile-aware configuration |
| 4 | H2, JPA, transactions | Persistent catalog with migration |
| 5 | REST API and error design | Versioned CRUD API |
| 6 | MySQL and persistence engineering | Container-backed database profile |
| 7 | AOP and observability | Timed application service |
| 8 | Caching and OpenAPI | Cache policy and interactive API docs |
| 9 | Unit, slice, and integration testing | Layered automated test suite |
| 10 | Contract, end-to-end, and capstone | Verified consumer contract and E2E flow |

## Quick start

```bash
java -version
mvn -version
cd starter
mvn spring-boot:run
```

Open `http://localhost:8080/actuator/health`. For the finished application:

```bash
cd solution
mvn clean verify
mvn spring-boot:run
```

Then visit `http://localhost:8080/swagger-ui.html`.

## Lab method

Each lab contains objectives, a short architecture briefing, implementation steps, evidence to capture, failure-injection prompts, extension exercises, checkpoint questions, and trainer notes. Participants begin in `starter`, evolve their own application, and compare with `solution` only after the checkpoint review.

## Training convention

Examples favor constructor injection, immutable API records, explicit transaction boundaries, RFC 9457 problem details, database migrations, bounded caching, and tests selected by risk. Credentials in this repository are local-development defaults only.
