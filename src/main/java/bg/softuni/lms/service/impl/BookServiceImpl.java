package bg.softuni.lms.service.impl;

import bg.softuni.lms.model.dto.AuthorDto;
import bg.softuni.lms.model.dto.BookDto;
import bg.softuni.lms.model.entity.AuthorEntity;
import bg.softuni.lms.model.entity.BookEntity;
import bg.softuni.lms.repository.AuthorRepository;
import bg.softuni.lms.repository.BookRepository;
import bg.softuni.lms.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<BookDto> findBookById(Long id) {
        return bookRepository
                .findById(id)
                .map(BookServiceImpl::map);
    }

    @Override
    public Long createBook(BookDto bookDto) {

        Optional<AuthorEntity> authorEntityOpt = authorRepository
                .findByName(bookDto.getAuthor().getName());

        BookEntity book = new BookEntity()
                .setAuthor(authorEntityOpt.orElseGet(() ->
                        authorRepository.save(new AuthorEntity()
                                .setName(bookDto.getAuthor().getName()))))
                .setTitle(bookDto.getTitle())
                .setIsbn(bookDto.getIsbn());

        book = bookRepository.save(book);

        return book.getId();
    }

    public BookEntity save(BookEntity book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public BookEntity getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(BookServiceImpl::map)
                .toList();
    }

    private static BookDto map(BookEntity bookEntity) {
        AuthorDto authorDto = new AuthorDto()
                .setName(bookEntity.getAuthor().getName());

        return new BookDto()
                .setTitle(bookEntity.getTitle())
                .setAuthor(authorDto)
                .setIsbn(bookEntity.getTitle());
    }
}
