package com.readingbackend.Backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@IdClass(MemberBookId.class)
@Table(name = "member_book")
public class MemberBook {

    @Id
    @Column(name = "bookid", unique = true)
    private String bookId;
    @Id
    @Column(name = "userid", unique = true)
    private Long userId;
    @Column(name = "status")
    private String status;

    public MemberBook() {

    }

    public MemberBook(String bookId, Long userId) {
        this.bookId = bookId;
        this.userId = userId;
        this.status = "Not Read";
    }

    public MemberBook(String bookId, Long userId, String status) {
        this.bookId = bookId;
        this.userId = userId;
        this.status = status;
    }

    public String getBookId() {
        return bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
