# Day 1 — Spring and Spring Boot Foundations

**Time:** 3 hours guided + 2 hours practice  
**Outcome:** Run and explain a Java 21 Spring Boot application from IDE, Maven, and executable JAR.

## Architecture briefing

`main()` delegates to `SpringApplication`, which creates the environment, selects an application context, discovers configuration, registers beans, refreshes the context, and starts the embedded server. Spring Framework supplies the container and programming model; Spring Boot supplies opinionated dependency management, auto-configuration, starters, packaging, and production conventions.

## Lab

1. Import `starter/pom.xml` as an existing Maven project in IntelliJ IDEA, Eclipse/STS, or VS Code.
2. Inspect the dependency tree: `mvn dependency:tree`.
3. Run `CatalogApplication`; find the server port and startup time in the log.
4. Call `GET /actuator/health` and explain every response field.
5. Package with `mvn clean package`; inspect `target` and run the executable JAR.
6. Add an `ApplicationRunner` bean that logs Java version, active profiles, and bean count.
7. Run the context test and deliberately break component scanning to observe the failure.

## Evidence

- Health response, startup log, packaged JAR, and passing test.
- A diagram from JVM entry point to listening HTTP socket.

## Failure injection

Occupy port 8080, restart, diagnose the failure, and override the port without changing Java code.

## Checkpoint questions

1. What is Spring Boot adding that Spring Framework does not?
2. Why is `@SpringBootApplication` placed in the root package?
3. What makes a Boot JAR executable?
4. When would explicit configuration beat auto-configuration?

## Trainer notes

Ask learners to predict before running. Use `--debug` once to show the condition evaluation report, but focus on a few relevant matches rather than reading the entire report. Challenge the claim that Boot is “code generation”; it configures normal Spring beans at runtime.
