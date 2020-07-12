package com.example.Library.book;

import com.example.Library.author.Author;
import com.example.Library.author.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public BookService(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public Book insertBook(Book book) {
        return bookRepo.save(book);
    }

    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }

    public Book updateBook(int id, Book updatedBook) {
        Book originalBook = bookRepo.getOne(id);
        originalBook.setTitle(updatedBook.getTitle());
        originalBook.setDescription(updatedBook.getDescription());

        return bookRepo.save(originalBook);
    }

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

}
