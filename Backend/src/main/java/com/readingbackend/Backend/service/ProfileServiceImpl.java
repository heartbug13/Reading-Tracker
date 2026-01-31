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

    //private final EmailService emailService;

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

    /*
    @Override
    public void sendResetOtp(String email) {
        UserEntity existingEntity = userRepostory.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: "+email));

        //Generate 6 digit otp
        String otp = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 1000000));

        //calculate expiry time (current time + 15 minutes in milliseconds)
        long expiryTime = System.currentTimeMillis() + (15 * 60 * 1000);

        //update the profile/user
        existingEntity.setResetOtp(otp);
        existingEntity.setResetOtpExpireAt(expiryTime);

        //save into the database
        userRepostory.save(existingEntity);

        try{
            emailService.sendResetOtpEmail(existingEntity.getEmail(), otp);
        } catch(Exception ex) {
            throw new RuntimeException("Unable to send email");
        }

    }

     */

    @Override
    public void resetPassword(String email, String otp, String newPassword) {
        Member existingUser =  memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
        /*
        if (existingUser.getResetOtp() == null || !existingUser.getResetOtp().equals(otp)) {
            throw new RuntimeException("Invalid OTP");
        }

        if (existingUser.getResetOtpExpireAt() < System.currentTimeMillis()) {
            throw new RuntimeException("OTP Expired");
        }

         */

        existingUser.setPassword(passwordEncoder.encode(newPassword));
        //existingUser.setResetOtp(null);
        //existingUser.setResetOtpExpireAt(0L);

        memberRepository.save(existingUser);

    }

    /*
    @Override
    public void sendOtp(String email) {
        UserEntity existingUser = userRepostory.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: "+email));

        if (existingUser.getIsAccountVerified() != null && existingUser.getIsAccountVerified()) {
            return;
        }

        //Generate 6 digit OTP
        String otp = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 1000000));

        //calculate expiry time (current time + 24 hours in milliseconds)
        long expiryTime = System.currentTimeMillis() + (24 * 60 * 60 * 1000);

        //Update the user entity
        existingUser.setVerifyOtp(otp);
        existingUser.setVerifyOtpExpireAt(expiryTime);

        //save to database
        userRepostory.save(existingUser);

        try {
            emailService.sendOtpEmail(existingUser.getEmail(), otp);
        } catch (Exception e) {
            throw new RuntimeException("Unable to send email");
        }
    }

    @Override
    public void verifyOtp(String email, String otp) {
        UserEntity existingUser = userRepostory.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: "+email));
        if (existingUser.getVerifyOtp() == null || !existingUser.getVerifyOtp().equals(otp)) {
            throw new RuntimeException("Invalid OTP");
        }

        if (existingUser.getVerifyOtpExpireAt() < System.currentTimeMillis()) {
            throw new RuntimeException("OTP Expired");
        }


        existingUser.setIsAccountVerified(true);
        existingUser.setVerifyOtp(null);
        existingUser.setVerifyOtpExpireAt(0L);

        userRepostory.save(existingUser);
    }

     */

    private ProfileResponse convertToProfileResponse(Member newProfile) {
        return ProfileResponse.builder()
                .name(newProfile.getUsername())
                .email(newProfile.getEmail())
                .userid(newProfile.getUserid())
                //.isAccountVerified(newProfile.getIsAccountVerified())
                .build();
    }

    private Member convertToUserEntity(ProfileRequest request) {
        return Member.builder()
                .email(request.getEmail())
                //.userid(UUID.randomUUID().toString())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                //.isAccountVerified(false)
                //.resetOtpExpireAt(0L)
                //.verifyOtp(null)
                //.verifyOtpExpireAt(0L)
                //.resetOtp(null)
                .build();
    }
}
