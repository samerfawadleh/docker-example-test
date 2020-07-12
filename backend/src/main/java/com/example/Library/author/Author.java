package com.example.Library.author;

import com.example.Library.book.Book;
import com.example.Library.bookVersion.BookVersion;
import com.example.Library.configurations.auditFields.AuditFields;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "author")
@EntityListeners(AuditingEntityListener.class)
public class Author extends AuditFields {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;

//    @ManyToMany
//    @JoinTable(
//            name = "book_author",
//            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
//    )
//    private List<Book> books;

    @OneToMany(mappedBy = "author")
    private Set<BookVersion> bookVersions;

    public Set<BookVersion> getBookVersions() {
        return bookVersions;
    }

    public void setBookVersions(Set<BookVersion> bookVersions) {
        this.bookVersions = bookVersions;
    }

    public Author() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

}
