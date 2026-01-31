package com.readingbackend.Backend.service;

import com.readingbackend.Backend.responses.ProfileRequest;
import com.readingbackend.Backend.responses.ProfileResponse;
import jakarta.validation.Valid;

public interface ProfileService {

    ProfileResponse createProfile(@Valid ProfileRequest request);

    ProfileResponse getProfile(String email);

    //void sendResetOtp(String email);

    void resetPassword(String email, String otp, String newPassword);

   // void sendOtp(String email);

    //void verifyOtp(String email, String otp);
}
