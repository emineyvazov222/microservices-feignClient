package az.company.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDto {

    private Long id;
    private List<BookDto> userBookMap;

    public LibraryDto(Long id) {
        this.id = id;
    }
}
