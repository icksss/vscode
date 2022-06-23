package com.example.demo.service;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.domain.User;



public interface UserService extends UserDetailsService {
     Collection<GrantedAuthority> getAuthorities(String username);
     public void createUser(User user);
     public void deleteUser(String username);
     public PasswordEncoder passwordEncoder();
}