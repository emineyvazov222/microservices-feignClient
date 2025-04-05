package az.company.libraryservice.client;

import az.company.libraryservice.dto.BookDto;
import az.company.libraryservice.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "book-service",
        url = "http://localhost:8080/v1/book")
public interface BookServiceClient {

    @GetMapping("/book/{id}")
    ResponseEntity<BookDto> getBookById(@PathVariable Long id);

    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn);

}
