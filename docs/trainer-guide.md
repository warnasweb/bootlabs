# Trainer Guide

## Facilitation model

Use a 20/30/40/10 rhythm: 20% concept and architecture, 30% live construction, 40% participant lab, 10% review. Start each implementation with a prediction and end with evidence. Treat the reference solution as a review artifact, not a typing target.

## Daily schedule

| Time | Activity |
|---|---|
| 09:00–09:30 | Retrieval quiz and architecture briefing |
| 09:30–10:30 | Live construction and diagnostic walkthrough |
| 10:45–12:15 | Guided lab |
| 13:00–14:30 | Independent lab and extensions |
| 14:45–15:45 | Failure injection / debugging |
| 15:45–16:30 | Code review, checkpoint questions, evidence |

## Assessment rubric

Score each dimension 0–3:

1. **Correctness:** builds, runs, handles happy and unhappy paths.
2. **Architecture:** dependencies and responsibilities are deliberate.
3. **Spring understanding:** participant explains container/proxy/configuration behavior.
4. **Persistence:** transaction, query, migration, and concurrency choices are sound.
5. **API contract:** semantics, validation, errors, and documentation are stable.
6. **Testing:** scope matches risk; tests are deterministic and diagnostic.
7. **Operations:** configuration, health, logs, and secrets are production-aware.

Minimum E2 completion: no zero, total at least 15/21, and a passing capstone demonstration.

## Review prompts

- What failure is this design preventing?
- What creates this object, and at what lifecycle stage?
- Does this call cross a proxy?
- Where does the transaction begin and end?
- Which statement causes SQL, and how many times?
- What can a consumer safely depend on?
- What is the smallest credible automated test?

## Version policy

The repository pins versions for repeatability. Before a new cohort, review Spring Boot release notes, Java support, springdoc compatibility, database image tags, and GitHub Action major versions. Upgrade on a separate branch and run the full build before training.
