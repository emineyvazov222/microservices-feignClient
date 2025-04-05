package az.company.libraryservice.controller;

import az.company.libraryservice.dto.BookRequest;
import az.company.libraryservice.dto.LibraryDto;
import az.company.libraryservice.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable Long id) {
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary() {
        return ResponseEntity.ok(libraryService.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> updateLibrary(@RequestBody BookRequest bookRequest) {
        libraryService.addBookToLibrary(bookRequest);
        return ResponseEntity.ok().build();
    }
}
