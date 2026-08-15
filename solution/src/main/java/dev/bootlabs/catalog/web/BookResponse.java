package dev.bootlabs.catalog.web;

import dev.bootlabs.catalog.domain.Book;
import java.math.BigDecimal;

public record BookResponse(long id, String isbn, String title, String author, BigDecimal price, long version) {
    static BookResponse from(Book book) {
        return new BookResponse(book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getVersion());
    }
}
