# Day 2 — Components, DI, Maven, and the Embedded Server

**Outcome:** Build a layered feature and reason about bean creation, dependency direction, scopes, and classpath-driven configuration.

## Architecture briefing

HTTP request → DispatcherServlet → controller → application service → repository. Constructor injection makes required dependencies visible and testable. Stereotype annotations communicate architectural role; bean identity still comes from the container.

## Lab

1. Create `Book`, `BookRepository`, an in-memory repository, `BookService`, and `BookController`.
2. Use constructor injection only. Inspect beans through `/actuator/beans` temporarily.
3. Add two repository implementations and observe ambiguity; resolve it with `@Primary`, then compare `@Qualifier`.
4. Inspect the effective POM and identify inherited plugin/dependency management.
5. Exclude Tomcat, add Jetty, and compare startup logs and dependency trees; restore Tomcat afterward.
6. Add a test proving the service can be constructed without a Spring context.

## Design exercise

Classify each concern—HTTP status, transaction, validation, storage, mapping—into the appropriate layer. Explain what would break if the domain imported Spring MVC.

## Checkpoint questions

1. How does component scanning differ from auto-configuration?
2. Why is field injection harmful?
3. What does a starter contain?
4. How does Boot decide which embedded server to start?

## Trainer notes

Have learners inspect actual runtime bean types because proxying becomes important later. Stress that layers are dependency boundaries, not merely package names.
