# Day 5 — RESTful Web Services and Error Design

**Outcome:** Deliver a versioned CRUD API with correct semantics, validation, mapping, and RFC 9457 errors.

## Lab

1. Create request/response records; never expose JPA entities directly.
2. Implement list, retrieve, create, update, and delete under `/api/v1/books`.
3. Return `201 Created` plus `Location` for creation and `204 No Content` for deletion.
4. Validate ISBN, title, author, and positive price at the boundary.
5. Centralize failures with `@RestControllerAdvice` and `ProblemDetail`.
6. Prove the `404`, `409`, and validation `400` contracts with MockMvc.
7. Discuss PUT idempotency and design a PATCH request without implementing it.

## API review checklist

- Resource-oriented URIs; no verbs in paths.
- Stable external DTOs and explicit mapping.
- HTTP method, status, caching, and idempotency semantics.
- No stack traces or internal class names in errors.

## Checkpoint questions

1. Why separate transport DTOs from entities?
2. Is HTTP status part of the API contract?
3. What makes an operation idempotent?
4. Where should pagination metadata live?

## Trainer notes

Run a design review before coding. Ask participants to justify each status code from client behavior, not habit. The solution intentionally demonstrates a simple full replacement update; discuss preservation of immutable ISBN.
