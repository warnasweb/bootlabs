# Environment Setup

## Required

1. Install a Java 21 JDK and verify `java -version` and `javac -version`.
2. Install Maven 3.6.3 or later and verify `mvn -version` reports Java 21.
3. Install Git and an IDE with Java/Maven support.
4. Install Docker Desktop for Days 6 and 10.
5. Clone this repository and run `mvn clean verify`.

## IDE import

- **Eclipse/STS:** File → Import → Existing Maven Projects → select `starter`.
- **IntelliJ IDEA:** File → Open → select `starter/pom.xml`.
- **VS Code:** install Extension Pack for Java, then open the repository.

Enable annotation processing only if an added library requires it; the supplied project does not depend on generated application code.

## Troubleshooting

- Wrong JDK: align IDE Project SDK, Maven runner JRE, and `JAVA_HOME`.
- Port conflict: run with `--server.port=8081` or stop the process using 8080.
- Stale dependencies: use Maven reload before deleting caches.
- Docker unavailable: complete H2 work and return to container-specific extensions later.
- MySQL does not become healthy: inspect `docker compose -f infrastructure/compose.yaml logs mysql`.

## Useful endpoints

| Endpoint | Purpose |
|---|---|
| `/actuator/health` | Readiness and dependencies |
| `/api/v1/books` | Catalog resource |
| `/swagger-ui.html` | Interactive documentation |
| `/v3/api-docs` | OpenAPI JSON |
| `/h2-console` | Local H2 inspection only |
