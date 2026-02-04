package com.readingbackend.Backend.responses;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Setter
public class MemberBookPutRequest {
    private String bookId;
    private Long userId;
    private String status;

    public MemberBookPutRequest() {

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
}
