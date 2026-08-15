package dev.bootlabs.catalog.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.bootlabs.catalog.domain.Book;
import dev.bootlabs.catalog.domain.BookRepository;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock BookRepository repository;

    @Test void returnsExistingBook() {
        var book = new Book("9780134685991", "Effective Java", "Joshua Bloch", new BigDecimal("49.90"));
        when(repository.findById(7L)).thenReturn(Optional.of(book));
        assertThat(new BookService(repository).find(7L)).isSameAs(book);
    }

    @Test void reportsMissingBook() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> new BookService(repository).find(99L)).isInstanceOf(BookNotFoundException.class);
        verify(repository).findById(99L);
    }
}
