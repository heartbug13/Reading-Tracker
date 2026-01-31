package com.readingbackend.Backend.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberBookDto {
    public String bookId;
    public String bookTitle;
    public String bookUrl;
    public String authors;
    public String status;
}
