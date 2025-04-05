package az.company.bookservice.controller;

import az.company.bookservice.dto.BookDto;
import az.company.bookservice.dto.BookIdDto;
import az.company.bookservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable @NotEmpty String isbn) {
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty Long id) {
        return ResponseEntity.ok(bookService.findBookDetailsById(id));
    }
}
