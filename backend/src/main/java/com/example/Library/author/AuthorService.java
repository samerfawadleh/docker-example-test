package com.example.Library.author;

import com.example.Library.book.Book;
import com.example.Library.book.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public AuthorService(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    public Author insertAuthor(Author author) {
        return authorRepo.save(author);
    }

    public void deleteAuthor(int id) { authorRepo.deleteById(id); }

    public Author updateAuthor(int id, Author updatedAuthor) {
        Author originalAuthor = authorRepo.getOne(id);
        originalAuthor.setFirstName(updatedAuthor.getFirstName());
        originalAuthor.setLastName((updatedAuthor.getLastName()));
//        originalAuthor.setBooks(updatedAuthor.getBooks());
        
        return authorRepo.save(originalAuthor);
    }

    public List<Author> getBooks() {
        return authorRepo.findAll();
    }

    public Author getAuthorFromPayload(Map<String, Object> payload) {
        Author author = new Author();
        author.setFirstName(payload.get("firstName").toString());
        author.setLastName(payload.get("lastName").toString());
        List<Integer> booksIds = (List<Integer>) payload.get("books");

        List<Book> books = bookRepo.findAllById(booksIds);
//        author.setBooks(books);

        return author;
    }
}
