package com.readingbackend.Backend.service;

import com.readingbackend.Backend.model.Member;
import com.readingbackend.Backend.repository.MemberRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AppMemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public AppMemberDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @NonNull
    @Override
    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
        System.out.println("this is loading a user by email");
        Member existingMember = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found for the email " + email));
        return new User(existingMember.getEmail(), existingMember.getPassword(), new ArrayList<>());
    }
}
