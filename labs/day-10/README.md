# Day 10 — Contract Testing, End-to-End Testing, and Capstone

**Outcome:** Verify compatibility at service boundaries and demonstrate a complete production-like workflow.

## Contract lab

1. Treat the create-book request/response as a consumer contract.
2. Assert method, path, required request fields, status, Location header, and stable response fields.
3. Change a response field and observe the contract failure.
4. Explain how consumer-driven contracts scale with Pact or Spring Cloud Contract in a distributed system.
5. Decide which semantic rules remain outside a schema contract.

## End-to-end lab

1. Start the application on a random port.
2. Create, read, update, list, and delete a book over real HTTP.
3. Run the flow against PostgreSQL/Testcontainers when Docker is available.
4. Capture logs, status codes, database state, cache behavior, and Actuator health.
5. Add one negative workflow: duplicate ISBN or invalid price.

## Capstone challenge

Add inventory reservation to the catalog:

- Migration and entity fields for available quantity.
- Atomic service operation with transaction and optimistic locking.
- `POST /api/v1/books/{id}/reservations` with validated quantity.
- Problem response for insufficient stock.
- Cache policy that cannot return incorrect availability.
- OpenAPI documentation and example.
- Unit, persistence, API contract, and end-to-end evidence.

## Definition of done

- `mvn clean verify` succeeds on Java 21.
- No credentials in Java source or Git history.
- Migration owns schema evolution; JPA validates it.
- API errors are stable and safe.
- Tests are layered and their intent is documented.
- Participant presents architecture and one deliberate tradeoff in ten minutes.

## Checkpoint questions

1. Contract test versus integration test: what changes?
2. Why keep E2E tests few?
3. What does a contract fail to prove?
4. Where should a compatibility check run in CI?

## Trainer notes

Timebox implementation and preserve the final presentation. Grade reasoning, failure handling, and evidence—not feature volume. Use the reference application's `BookApiContractTest` and `CatalogEndToEndTest` as minimum examples, not maximum ambition.
