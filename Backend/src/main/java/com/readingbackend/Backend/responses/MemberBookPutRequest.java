package com.readingbackend.Backend.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberBookPutRequest {
    private String bookId;
    private Long userId;
    private String status;
}
