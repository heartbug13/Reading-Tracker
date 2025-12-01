package com.readingbackend.Backend.member_book;

import jakarta.persistence.*;

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
    private String userId;

    @Column(name = "status")
    private String status;
    @Column(name = "startdate")
    private LocalDate startDate;
    @Column(name = "enddate")
    private LocalDate endDate;

    public MemberBook() {

    }

    public MemberBook(String bookId, String userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    public MemberBook(String bookId, String userId, String status, LocalDate startDate, LocalDate endDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getBookId() {
        return bookId;
    }

    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Member_Book{" +
                "bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", status='" + status + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

}
