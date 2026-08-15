# Day 9 — Unit, Slice, and Integration Testing

**Outcome:** Select the smallest test scope that gives useful confidence and keep a fast, diagnostic build.

## Test portfolio

| Scope | Tool | Proves |
|---|---|---|
| Unit | JUnit + Mockito | Branching and collaboration in one class |
| Persistence slice | `@DataJpaTest` | Mapping, queries, constraints |
| Web slice | MockMvc | HTTP mapping, validation, serialization |
| Integration | `@SpringBootTest` | Bean wiring and infrastructure integration |

## Lab

1. Unit-test `BookService` without Spring; cover success, missing book, duplicate ISBN, and update.
2. Write a repository slice test for ISBN lookup and uniqueness.
3. Write controller tests for statuses, headers, JSON, validation, and problem details.
4. Add a full-context test only for behavior that crosses layers.
5. Use a test-data builder to remove irrelevant setup.
6. Introduce a mutation manually and identify which test catches it.
7. Run `mvn clean verify`; compare duration and failure diagnostics by test type.

## Review exercise

Classify five candidate tests by risk. Reject assertions on implementation detail, unnecessary mocks, sleep-based timing, and full-context tests for pure calculations.

## Checkpoint questions

1. Why is coverage not a confidence metric by itself?
2. When is mocking a repository appropriate?
3. What does a slice exclude?
4. What makes a test deterministic?

## Trainer notes

Ask “what production failure does this prevent?” for every test. Show that one precise assertion can be more valuable than a large snapshot. Keep Docker-dependent tests in a separately understood layer.
