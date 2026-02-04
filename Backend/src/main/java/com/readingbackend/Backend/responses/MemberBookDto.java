package com.readingbackend.Backend.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MemberBookDto {
    public String bookId;
    public String bookTitle;
    public String bookUrl;
    public String authors;
    public String status;
}
