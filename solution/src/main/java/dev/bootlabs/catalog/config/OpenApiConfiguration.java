package dev.bootlabs.catalog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OpenApiConfiguration {
    @Bean
    OpenAPI catalogApi() {
        return new OpenAPI().info(new Info().title("Book Catalog API").version("v1")
                .description("Reference API for the Spring Boot E2 labs"));
    }
}
