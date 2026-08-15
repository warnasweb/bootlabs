package dev.bootlabs.catalog;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogEndToEndTest {
    private final TestRestTemplate http;
    CatalogEndToEndTest(TestRestTemplate http) { this.http = http; }

    @Test void createThenReadBook() {
        var request = new Request("9780134685991", "Effective Java", "Joshua Bloch", new BigDecimal("49.90"));
        var created = http.postForEntity("/api/v1/books", request, Response.class);
        assertThat(created.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        var found = http.getForEntity(created.getHeaders().getLocation(), Response.class);
        assertThat(found.getBody().title()).isEqualTo("Effective Java");
    }

    record Request(String isbn, String title, String author, BigDecimal price) {}
    record Response(long id, String isbn, String title, String author, BigDecimal price, long version) {}
}
