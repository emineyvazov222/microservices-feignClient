package az.company.bookservice.dto;

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

    public static BookIdDto convert(Long bookId, String isbn) {
        return new BookIdDto(bookId, isbn);
    }
}
