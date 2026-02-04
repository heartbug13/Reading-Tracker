package com.readingbackend.Backend.responses;

import com.readingbackend.Backend.model.Book;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MemberBookPostRequest {
    private Long userId;
    private Book book;
}

