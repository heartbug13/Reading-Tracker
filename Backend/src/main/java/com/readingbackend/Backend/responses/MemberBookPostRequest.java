package com.readingbackend.Backend.responses;

import com.readingbackend.Backend.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberBookPostRequest {
    private Long userId;
    private Book book;
}

