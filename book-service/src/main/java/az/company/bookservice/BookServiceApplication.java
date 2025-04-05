package az.company.bookservice;

import az.company.bookservice.entity.BookEntity;
import az.company.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BookServiceApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BookEntity book1 = new BookEntity(null, "Effective Java", 2018,
                "Joshua Bloch", "Pearson", "978-0-13-468599-1");
        BookEntity book2 = new BookEntity(null, "Clean Code", 2008,
                "Robert C. Martin", "Prentice Hall", "978-0-13-235088-4");
        BookEntity book3 = new BookEntity(null, "The Pragmatic Programmer", 1999,
                "Andrew Hunt & David Thomas", "Addison-Wesley", "978-0-201-61622-4");

        List<BookEntity> bookList = bookRepository.saveAll(Arrays.asList(book1, book2, book3));
        System.out.println(bookList);
    }
}
