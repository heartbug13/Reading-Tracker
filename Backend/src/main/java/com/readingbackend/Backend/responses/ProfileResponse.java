package com.readingbackend.Backend.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProfileResponse {

    private Long userid;
    private String name;
    private String email;
    //private Boolean isAccountVerified;
}

