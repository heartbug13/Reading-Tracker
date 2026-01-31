package com.readingbackend.Backend.service;

import com.readingbackend.Backend.model.Member;
import com.readingbackend.Backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AppMemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member existingMember = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found for the email " + email));
        return new User(existingMember.getEmail(), existingMember.getPassword(), new ArrayList<>());
    }
}
