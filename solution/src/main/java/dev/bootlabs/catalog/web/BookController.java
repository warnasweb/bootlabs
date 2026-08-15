package dev.bootlabs.catalog.web;

import dev.bootlabs.catalog.observability.TimedOperation;
import dev.bootlabs.catalog.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService service;
    public BookController(BookService service) { this.service = service; }

    @GetMapping
    @Operation(summary = "List books")
    public List<BookResponse> all() { return service.findAll().stream().map(BookResponse::from).toList(); }

    @GetMapping("/{id}")
    @TimedOperation("catalog.book.read")
    public BookResponse one(@PathVariable long id) { return BookResponse.from(service.find(id)); }

    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest request) {
        var book = service.create(request.isbn(), request.title(), request.author(), request.price());
        return ResponseEntity.created(URI.create("/api/v1/books/" + book.getId())).body(BookResponse.from(book));
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable long id, @Valid @RequestBody BookRequest request) {
        return BookResponse.from(service.update(id, request.title(), request.author(), request.price()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }
}
