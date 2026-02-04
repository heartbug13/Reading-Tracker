package com.readingbackend.Backend.responses;

import com.readingbackend.Backend.model.Book;
import lombok.*;

@Data
@Builder
@Setter
public class MemberBookPostRequest {
    private Long userId;
    private Book book;

    public MemberBookPostRequest() {

    }

    public MemberBookPostRequest(Long userId, Book book) {
        this.userId = userId;
        this.book = book;
    }

    public Long getUserId() {
        return userId;
    }

    public Book getBook() {
        return book;
    }
}

