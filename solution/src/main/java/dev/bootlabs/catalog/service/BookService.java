package dev.bootlabs.catalog.service;

import dev.bootlabs.catalog.domain.Book;
import dev.bootlabs.catalog.domain.BookRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository books;
    public BookService(BookRepository books) { this.books = books; }

    public List<Book> findAll() { return books.findAll(); }

    @Cacheable(cacheNames = "books", key = "#id")
    public Book find(long id) { return books.findById(id).orElseThrow(() -> new BookNotFoundException(id)); }

    @Transactional
    public Book create(String isbn, String title, String author, BigDecimal price) {
        if (books.existsByIsbn(isbn)) throw new DuplicateIsbnException(isbn);
        return books.save(new Book(isbn, title, author, price));
    }

    @Transactional
    @CachePut(cacheNames = "books", key = "#id")
    public Book update(long id, String title, String author, BigDecimal price) {
        var book = find(id);
        book.revise(title, author, price);
        return book;
    }

    @Transactional
    @CacheEvict(cacheNames = "books", key = "#id")
    public void delete(long id) { books.delete(find(id)); }
}
