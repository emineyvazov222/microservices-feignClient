package az.company.libraryservice.exceptions;

public class LibraryNotFoundException extends RuntimeException {

    public LibraryNotFoundException(String message) {
        super(message);
    }
}
