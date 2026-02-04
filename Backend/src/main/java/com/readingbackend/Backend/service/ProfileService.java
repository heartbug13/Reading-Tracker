package com.readingbackend.Backend.service;

import com.readingbackend.Backend.responses.ProfileRequest;
import com.readingbackend.Backend.responses.ProfileResponse;
import jakarta.validation.Valid;

public interface ProfileService {

    ProfileResponse createProfile(@Valid ProfileRequest request);

    ProfileResponse getProfile(String email);

}
