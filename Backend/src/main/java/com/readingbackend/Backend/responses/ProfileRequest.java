package com.readingbackend.Backend.responses;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ProfileRequest {

    @NotBlank(message = "Username should be not empty")
    private String username;

    @Email(message = "Enter valid email address")
    @NotNull(message = "Email should be not empty")
    private String email;

    @Size(min = 6, message = "Password must be atleast 6 characters")
    private String password;

}
