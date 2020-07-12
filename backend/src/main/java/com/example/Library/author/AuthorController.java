package com.example.Library.author;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<?> insertAuthor(@RequestBody Map<String, Object> payload) {
        Author author = authorService.getAuthorFromPayload(payload);
        return ResponseEntity.ok(authorService.insertAuthor(author));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") int id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable("id") int id, @RequestBody Map<String, Object> payload) {
        Author author = authorService.getAuthorFromPayload(payload);
        return ResponseEntity.ok(authorService.updateAuthor(id, author));
    }

    @GetMapping
    public ResponseEntity<?> getAuthors() {
        return ResponseEntity.ok(authorService.getBooks());
    }
}
