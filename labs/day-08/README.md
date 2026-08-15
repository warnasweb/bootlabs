# Day 8 — Caching and OpenAPI Documentation

**Outcome:** Design an explicit cache consistency policy and publish trustworthy interactive API documentation.

## Lab A — Cache

1. Add Spring Cache and Caffeine; enable caching in configuration.
2. Cache `find(id)` using the stable ID as key.
3. Use `@CachePut` for update and `@CacheEvict` for delete.
4. Bound size and expiry; explain both limits from workload assumptions.
5. Use Actuator cache/metric endpoints to observe behavior.
6. Prove repository invocation count on cache hit and eviction.
7. Discuss stale data in multi-instance deployments and when Redis is appropriate.

## Lab B — OpenAPI

1. Add springdoc and configure title, version, and description.
2. Open `/swagger-ui.html` and inspect `/v3/api-docs`.
3. Document operations, response codes, examples, constraints, and problem details.
4. Export the specification and review it as a consumer-facing contract.
5. Identify a documentation drift and fix code or specification.

## Checkpoint questions

1. Is caching a correctness decision or only a performance decision?
2. What causes a cache stampede?
3. Code-first versus design-first OpenAPI: what are the tradeoffs?
4. Which API details cannot be inferred reliably from controller signatures?

## Trainer notes

Require a cache invalidation story before annotations are added. In Swagger UI, test unhappy paths too; attractive documentation is not necessarily accurate documentation.
