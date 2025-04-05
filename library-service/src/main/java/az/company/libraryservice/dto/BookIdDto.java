package az.company.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookIdDto {

    private Long bookId;
    private String isbn;


    public static BookIdDto convert(Long id, String isbn) {
        return new BookIdDto(id, isbn);
    }
}
