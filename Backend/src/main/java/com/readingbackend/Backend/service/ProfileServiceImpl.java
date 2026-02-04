package com.readingbackend.Backend.service;


import com.readingbackend.Backend.model.Member;
import com.readingbackend.Backend.repository.MemberRepository;
import com.readingbackend.Backend.responses.ProfileRequest;
import com.readingbackend.Backend.responses.ProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
        Member newProfile = convertToUserEntity(request);
        if (!memberRepository.existsByEmail(request.getEmail())) {
            newProfile = memberRepository.save(newProfile);
            return convertToProfileResponse(newProfile);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
    }

    @Override
    public ProfileResponse getProfile(String email) {
        Member existingUser = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: "+email));
        return convertToProfileResponse(existingUser);
    }

    private ProfileResponse convertToProfileResponse(Member newProfile) {
        return ProfileResponse.builder()
                .name(newProfile.getUsername())
                .email(newProfile.getEmail())
                .userid(newProfile.getUserid())
                .build();
    }

    private Member convertToUserEntity(ProfileRequest request) {
        return Member.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }
}
