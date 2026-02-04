package com.readingbackend.Backend.responses;

import lombok.*;
import org.springframework.context.annotation.Profile;

@Data
@Builder
@Setter
public class ProfileResponse {

    private Long userid;
    private String name;
    private String email;

    public ProfileResponse() {

    }

    public ProfileResponse(Long userid, String name, String email) {
        this.userid = userid;
        this.name = name;
        this.email = email;
    }

    public Long getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

