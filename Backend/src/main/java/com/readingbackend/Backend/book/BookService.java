package com.readingbackend.Backend.book;

import org.springframework.stereotype.Component;

@Component
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }
}
