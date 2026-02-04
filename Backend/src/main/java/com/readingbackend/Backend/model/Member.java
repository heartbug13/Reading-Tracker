package com.readingbackend.Backend.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "member")
@Data
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userid", nullable = false)
    public Long userid;
    @Column(name = "email", unique = true, nullable = false)
    public String email;
    @Column(name = "username", unique = true, nullable = false)
    public String username;
    @Column(name = "password", nullable = false)
    public String password;

    public Member() {

    }
    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }
}
