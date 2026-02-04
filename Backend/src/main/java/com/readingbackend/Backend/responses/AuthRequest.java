package com.readingbackend.Backend.responses;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class AuthRequest {
    private String email;
    private String password;

    public AuthRequest () {

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
