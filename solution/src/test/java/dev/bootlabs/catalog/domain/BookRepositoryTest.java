package dev.bootlabs.catalog.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

@DataJpaTest(properties = "spring.jpa.hibernate.ddl-auto=create-drop")
class BookRepositoryTest {
    @Autowired BookRepository repository;

    @Test void findsByNaturalIdentifier() {
        repository.saveAndFlush(new Book("9780134685991", "Effective Java", "Joshua Bloch", new BigDecimal("49.90")));
        assertThat(repository.findByIsbn("9780134685991")).get().extracting(Book::getTitle).isEqualTo("Effective Java");
    }
}
