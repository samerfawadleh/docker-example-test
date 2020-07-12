package com.example.Library.book;

import com.example.Library.author.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<?> insertBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.insertBook(book));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @GetMapping
    public ResponseEntity<?> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }
}
