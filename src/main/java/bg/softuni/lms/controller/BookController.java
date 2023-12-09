package bg.softuni.lms.controller;

import bg.softuni.lms.model.dto.BookDto;
import bg.softuni.lms.model.entity.BookEntity;
import bg.softuni.lms.repository.BookRepository;
import bg.softuni.lms.service.BookService;
import bg.softuni.lms.service.impl.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookServiceImpl bookServiceImpl;
    private final BookService bookService;
    private final BookRepository bookRepository;

    public BookController(BookServiceImpl bookServiceImpl, BookService bookService, BookRepository bookRepository) {
        this.bookServiceImpl = bookServiceImpl;
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping
    public String listBooks(Model model) {
        List<BookEntity> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findBookById(@PathVariable("id") Long id) {
        Optional<BookDto> bookDtoOptional = bookService.findBookById(id);

        return bookDtoOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(
            @RequestBody BookDto bookDto,
            UriComponentsBuilder uriComponentsBuilder) {

        long newBookId = bookService.createBook(bookDto);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/books/{id}").build(newBookId))
                .build();
    }

    @PostMapping
    public BookEntity addBook(@RequestBody BookEntity book) {
        return bookServiceImpl.save(book);
    }

    @PutMapping("/{id}")
    public BookEntity updateBook(@PathVariable Long id, @RequestBody BookEntity book) {
        // Additional logic to ensure you're updating the correct book
        return bookServiceImpl.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookServiceImpl.deleteById(id);
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new BookEntity());
        return "books/add";
    }

    @GetMapping("/{id}/edit")
    public String editBookForm(@PathVariable Long id, Model model) {
        BookEntity book = bookServiceImpl.getBookById(id);
        model.addAttribute("book", book);
        return "books/edit";
    }

    @PostMapping("/{id}/edit")
    public String editBook(@PathVariable Long id, @ModelAttribute("book") BookEntity book) {
        book.setId(id);
        bookServiceImpl.save(book);
        return "redirect:/books/" + id;
    }
}
