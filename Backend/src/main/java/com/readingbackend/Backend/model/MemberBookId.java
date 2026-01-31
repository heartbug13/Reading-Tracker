package com.readingbackend.Backend.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class MemberBookId implements Serializable {
    private String bookId;
    private Long userId;

    public MemberBookId() {
    }

    public MemberBookId(String bookId, Long userId) {
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

        MemberBookId memberBookId = (MemberBookId) object;
        return Objects.equals(memberBookId.getBookId(), this.bookId) && Objects.equals(memberBookId.getUserId(), this.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, userId);
    }
}

