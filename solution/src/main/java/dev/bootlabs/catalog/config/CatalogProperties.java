package dev.bootlabs.catalog.config;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("catalog")
public record CatalogProperties(@Min(1) @Max(100) int defaultPageSize) {}
