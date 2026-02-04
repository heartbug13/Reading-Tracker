package com.readingbackend.Backend.responses;

import lombok.*;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class MemberBookDto {
    public String bookId;
    public String bookTitle;
    public String bookUrl;
    public String authors;
    public String status;

}
