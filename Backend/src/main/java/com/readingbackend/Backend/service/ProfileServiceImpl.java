package com.readingbackend.Backend.service;


import com.readingbackend.Backend.model.Member;
import com.readingbackend.Backend.repository.MemberRepository;
import com.readingbackend.Backend.responses.ProfileRequest;
import com.readingbackend.Backend.responses.ProfileResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public ProfileServiceImpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

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
        return new ProfileResponse(newProfile.getUserid(), newProfile.getUsername(), newProfile.getEmail());
    }

    private Member convertToUserEntity(ProfileRequest request) {
        return new Member(request.getUsername(), request.getEmail(), passwordEncoder.encode(request.getPassword()));
    }
}
