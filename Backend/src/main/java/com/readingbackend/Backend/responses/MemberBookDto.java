package com.readingbackend.Backend.responses;

import lombok.*;

@Data
@Builder
@Setter
public class MemberBookDto {
    public String bookId;
    public String bookTitle;
    public String bookUrl;
    public String authors;
    public String status;

    public MemberBookDto() {

    }

    public MemberBookDto(String bookId, String bookTitle, String bookUrl, String authors, String status) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookUrl = bookUrl;
        this.authors = authors;
        this.status = status;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public String getAuthors() {
        return authors;
    }

    public String getStatus() {
        return status;
    }
}
