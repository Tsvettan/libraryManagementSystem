package bg.softuni.lms.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity {
    private String title;
    private String isbn;
    private boolean borrowed;
    @ManyToOne
    private AuthorEntity author;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity borrowedBy;

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookEntity setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public BookEntity setAuthor(AuthorEntity author) {
        this.author = author;
        return this;
    }

    public UserEntity getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(UserEntity borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", borrowed=" + borrowed +
                '}';
    }
}
