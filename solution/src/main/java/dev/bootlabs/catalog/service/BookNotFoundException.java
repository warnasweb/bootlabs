package dev.bootlabs.catalog.service;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(long id) { super("Book %d was not found".formatted(id)); }
}
