package com.readingbackend.Backend.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthResponse {
    private String email;
    private String token;

}
