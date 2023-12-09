package bg.softuni.lms.service;

import bg.softuni.lms.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDto> getAllBooks();

    Optional<BookDto> findBookById(Long id);

    Long createBook(BookDto bookDto);
}
