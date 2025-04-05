package az.company.bookservice.dto;

import az.company.bookservice.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private Integer bookYear;
    private String author;
    private String pressName;

    public static BookDto convert(BookEntity from) {
        return BookDto.builder()
                .id(from.getId() != null ? BookIdDto.convert(from.getId(), from.getIsbn()).getBookId() : null)
                .title(from.getTitle())
                .bookYear(from.getBookYear())
                .author(from.getAuthor())
                .pressName(from.getPressName())
                .build();
    }
}
