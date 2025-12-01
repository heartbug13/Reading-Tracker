package com.readingbackend.Backend.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {
    @Id
    @Column(name="bookid", unique = true)
    String bookId;
    @Column(name="booktitle")
    String bookTitle;
    @Column(name="coverurl")
    String coverUrl;

    public Book() {}

    public Book(String bookId) {
        this.bookId = bookId;
    }

    public Book(String bookId, String bookTitle, String coverUrl) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.coverUrl = coverUrl;
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

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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
