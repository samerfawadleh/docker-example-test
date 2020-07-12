package com.example.Library.bookVersion;

import com.example.Library.author.Author;
import com.example.Library.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "bookVersion")
public class BookVersion {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private String version;

    public BookVersion() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
