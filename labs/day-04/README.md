# Day 4 — H2, JPA, Transactions, and Migrations

**Outcome:** Implement persistence with deliberate aggregate boundaries, queries, transactions, and schema ownership.

## Flow

Service transaction → persistence context → entity state changes → dirty checking → SQL → database commit. Repository interfaces are implemented by Spring Data; JPA still has unit-of-work and query-cost semantics that developers must understand.

## Lab

1. Add Data JPA, H2, Flyway, and validation dependencies.
2. Model `Book` with identity, unique ISBN, money precision, protected JPA constructor, and optimistic `@Version`.
3. Create `BookRepository`; derive a query by ISBN and inspect generated SQL.
4. Add Flyway `V1__create_books.sql`; use `ddl-auto=validate`.
5. Put transaction boundaries on the service. Mark query operations read-only.
6. Disable Open Session in View and ensure web mapping completes inside the intended boundary.
7. Write a `@DataJpaTest` for the unique ISBN and query method.

## Failure injection

Introduce an entity/schema mismatch, observe startup failure, and explain why this is preferable to silent drift.

## Extensions

- Add pagination and a case-insensitive title search.
- Reproduce an N+1 query with an author relationship, then fix it using an entity graph.

## Checkpoint questions

1. What does the persistence context guarantee?
2. Why not use `ddl-auto=update` in production?
3. Where does `@Transactional` fail under self-invocation?
4. What problem does optimistic locking solve?

## Trainer notes

Use SQL logs sparingly but require query-count reasoning. Avoid teaching repositories as magic; connect method calls to persistence-context and database behavior.
