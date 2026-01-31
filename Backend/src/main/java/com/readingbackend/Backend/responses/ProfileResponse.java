package com.readingbackend.Backend.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResponse {

    private Long userid;
    private String name;
    private String email;
    //private Boolean isAccountVerified;
}

