# Day 3 — Annotations, Configuration, Profiles, and Validation

**Outcome:** Create type-safe, validated configuration and explain annotation composition and conditional behavior.

## Lab

1. Add a `catalog.default-page-size` property and bind it to a Java record with `@ConfigurationProperties`.
2. Validate its range and demonstrate fail-fast startup with an invalid value.
3. Create `dev` and `production` profiles. Activate them using IDE, environment variable, and command line.
4. Add a small composed annotation combining `@Service` and a custom marker.
5. Compare `@Component`, `@Bean`, `@Configuration`, `@Import`, `@Profile`, and `@ConditionalOnProperty`.
6. Add an `EnvironmentPostProcessor` only as a reading exercise; explain why routine business configuration should not use it.
7. Write a context test using overridden properties.

## Configuration precedence experiment

Set the same property in YAML, an environment variable, and `--catalog.default-page-size=...`. Record the winning value and explain the precedence.

## Checkpoint questions

1. Why prefer configuration properties over scattered `@Value` fields?
2. What is meta-annotation composition?
3. When are profiles overused?
4. What is the difference between bean validation and business validation?

## Trainer notes

Keep secrets out of committed configuration. Emphasize that profile names describe environments while feature toggles describe capabilities. Point participants to the solution's `CatalogProperties` after their implementation review.
