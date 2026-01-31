package com.readingbackend.Backend.service;

import com.readingbackend.Backend.model.Book;
import com.readingbackend.Backend.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(String id) {
        Optional<Book> existingBook = bookRepository.findBookByBookId(id);
        return existingBook.orElse(null);
    }

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }
}
