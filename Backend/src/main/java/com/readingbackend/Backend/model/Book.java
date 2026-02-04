package com.readingbackend.Backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Table(name="book")
public class Book {
    @Setter
    @Id
    @Column(name="bookid", unique = true)
    String bookId;
    @Column(name="booktitle")
    String bookTitle;
    @Getter
    @Column(name="coverurl")
    String coverUrl;
    @Column(name="author")
    String author;

    public Book() {}

    public Book(String bookId) {
        this.bookId = bookId;
    }

    public Book(String bookId, String bookTitle, String coverUrl, String author) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.coverUrl = coverUrl;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Member_Book{" +
                "bookId='" + bookId + '\'' +
                ", userId='" + bookTitle + '\'' +
                ", status='" + coverUrl + '\'' +
                '}';
    }

}
