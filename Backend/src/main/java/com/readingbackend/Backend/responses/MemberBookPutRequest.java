package com.readingbackend.Backend.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MemberBookPutRequest {
    private String bookId;
    private Long userId;
    private String status;
}
