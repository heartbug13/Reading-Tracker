package com.readingbackend.Backend.responses;

import com.readingbackend.Backend.model.Book;
import lombok.*;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class MemberBookPostRequest {
    private Long userId;
    private Book book;

}

