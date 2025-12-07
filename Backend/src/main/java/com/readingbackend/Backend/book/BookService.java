package com.readingbackend.Backend.book;

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
        System.out.println(existingBook);
        if (existingBook.isPresent()) {
            return existingBook.get();
        }
        return null;
    }

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }
}
