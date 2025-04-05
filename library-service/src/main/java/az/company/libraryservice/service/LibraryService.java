package az.company.libraryservice.service;

import az.company.libraryservice.client.BookServiceClient;
import az.company.libraryservice.dto.BookRequest;
import az.company.libraryservice.dto.LibraryDto;
import az.company.libraryservice.entity.LibraryEntity;
import az.company.libraryservice.exceptions.LibraryNotFoundException;
import az.company.libraryservice.repository.LibraryRepository;


import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }


    public LibraryDto getAllBooksInLibraryById(Long libraryId) {
        LibraryEntity libraryEntity = libraryRepository.findById(libraryId)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + libraryId));

        return new LibraryDto(libraryEntity.getId(),
                libraryEntity.getUserBook()
                        .stream()
                        .map(book -> bookServiceClient.getBookById(book).getBody())
                        .collect(Collectors.toList()));
    }

    public LibraryDto createLibrary() {
        LibraryEntity save = libraryRepository.save(new LibraryEntity());
        return new LibraryDto(save.getId());
    }

    public void addBookToLibrary(BookRequest bookRequest) {
        Long bookId = Objects.requireNonNull(bookServiceClient.getBookByIsbn(bookRequest.getIsbn()).getBody()).getBookId();
        LibraryEntity library = libraryRepository.findById(bookRequest.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + bookRequest.getId()));
        library.getUserBook().add(bookId);

        libraryRepository.save(library);

    }
}
