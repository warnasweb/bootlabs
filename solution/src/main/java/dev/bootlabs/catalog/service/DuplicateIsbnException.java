package dev.bootlabs.catalog.service;

public class DuplicateIsbnException extends RuntimeException {
    public DuplicateIsbnException(String isbn) { super("ISBN already exists: " + isbn); }
}
