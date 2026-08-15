# Day 7 — AOP, Proxies, and Observability

**Outcome:** Implement a narrow cross-cutting concern and explain proxy boundaries, pointcuts, ordering, and failure modes.

## Architecture briefing

Caller → Spring proxy → advice chain → target method. Calls that never cross the proxy, including ordinary self-invocation, do not trigger proxy advice. AOP is useful for uniform technical policy, not hidden business workflow.

## Lab

1. Add the AOP starter and create `@TimedOperation`.
2. Implement `@Around` advice using `try/finally` so failures are timed too.
3. Apply the annotation to a read use case and verify log output.
4. Inspect the runtime class and determine whether JDK or class proxying is used.
5. Demonstrate self-invocation bypass with a controlled example, then remove it.
6. Add correlation ID propagation using a servlet filter; compare it with AOP.
7. Replace raw timing with a Micrometer timer as an extension.

## Checkpoint questions

1. What are join point, pointcut, advice, and aspect?
2. Why can final/private methods be problematic?
3. Why is broad package pointcut risky?
4. Which is better for HTTP correlation: filter, interceptor, or aspect?

## Trainer notes

Make the proxy visible; otherwise AOP looks mystical. Review log cardinality and sensitive-data risks. The solution uses logging for clarity, while a production system should usually record a metric.
