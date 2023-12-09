package bg.softuni.lms.model.dto;

import bg.softuni.lms.model.entity.BaseEntity;

public class BookDto extends BaseEntity {

    private String title;
    private String isbn;
    private boolean borrowed;
    private AuthorDto author;

    public String getTitle() {
        return title;
    }

    public BookDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookDto setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public BookDto setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
        return this;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public BookDto setAuthor(AuthorDto author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", borrowed=" + borrowed +
                ", author=" + author +
                '}';
    }
}
