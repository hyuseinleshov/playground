package com.example.test.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }
}
