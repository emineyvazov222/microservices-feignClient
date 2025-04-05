package az.company.bookservice.service;

import az.company.bookservice.dto.BookDto;
import az.company.bookservice.dto.BookIdDto;
import az.company.bookservice.entity.BookEntity;
import az.company.bookservice.exceptions.BookNotFoundException;
//import az.company.bookservice.mapper.BookMapper;
import az.company.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
//    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
//        this.bookMapper = bookMapper;
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookDto::convert).collect(Collectors.toList());
    }

    public BookIdDto findByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn)
                .map(bookEntity -> new BookIdDto(bookEntity.getId(), bookEntity.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn: " + isbn));

    }

    public BookDto findBookDetailsById(Long id) {
        return bookRepository.findById(id).map(BookDto::convert)
                .orElseThrow(() -> new BookNotFoundException("Book could not found by id: " + id));

    }
}
