# Day 6 — PostgreSQL and Production-Grade Persistence

**Outcome:** Run the same application against PostgreSQL and reason about portability, connection pools, migrations, indexes, and operational failure.

## Lab

1. Start PostgreSQL: `docker compose -f infrastructure/compose.yaml up -d`.
2. Run the solution with `--spring.profiles.active=postgres`.
3. Override credentials using `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD`.
4. Verify Flyway history and inspect the books table and index.
5. Compare H2 and PostgreSQL identity, reserved words, collation, decimals, and transaction behavior.
6. Add a composite index justified by a real query; capture its execution plan before and after.
7. Set a small Hikari pool and observe metrics under controlled concurrency.
8. Stop PostgreSQL during a request and document symptoms, recovery, and safe client behavior.

## Extension

Write a Testcontainers integration test using `@ServiceConnection`; keep it disabled only when Docker is unavailable.

## Checkpoint questions

1. Why can H2 tests pass while production fails?
2. Who owns schema change ordering?
3. How do pool size and database capacity interact?
4. What belongs in logs when database connectivity fails?

## Trainer notes

Local passwords are intentionally disposable. Demonstrate secret injection conceptually without requiring a cloud platform. Do not accept “add an index” without a query and plan measurement.
