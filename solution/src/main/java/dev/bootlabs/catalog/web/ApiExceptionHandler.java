package dev.bootlabs.catalog.web;

import dev.bootlabs.catalog.service.BookNotFoundException;
import dev.bootlabs.catalog.service.DuplicateIsbnException;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    ProblemDetail notFound(BookNotFoundException ex) { return problem(HttpStatus.NOT_FOUND, "Book not found", ex); }

    @ExceptionHandler(DuplicateIsbnException.class)
    ProblemDetail conflict(DuplicateIsbnException ex) { return problem(HttpStatus.CONFLICT, "Duplicate ISBN", ex); }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail invalid(MethodArgumentNotValidException ex) {
        var detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Request validation failed");
        detail.setTitle("Invalid request"); detail.setType(URI.create("https://bootlabs.dev/problems/validation"));
        detail.setProperty("errors", ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage()).toList());
        return detail;
    }

    private ProblemDetail problem(HttpStatus status, String title, Exception ex) {
        var detail = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
        detail.setTitle(title); detail.setType(URI.create("https://bootlabs.dev/problems/" + status.value()));
        return detail;
    }
}
