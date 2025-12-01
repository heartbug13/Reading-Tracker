package com.readingbackend.Backend.member_book;

import java.io.Serializable;
import java.util.Objects;

public class MemberBookId implements Serializable {
    private String bookId;
    private String userId;

    public MemberBookId() {}
    public MemberBookId(String bookId, String userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        MemberBookId that = (MemberBookId) object;
        return Objects.equals(bookId, this.bookId) && Objects.equals(userId, this.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, userId);
    }

    public String getBookId() {
        return bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

