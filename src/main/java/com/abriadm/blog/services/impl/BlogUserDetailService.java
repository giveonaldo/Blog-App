package com.abriadm.blog.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.abriadm.blog.entities.User;
import com.abriadm.blog.repositories.UserRepository;
import com.abriadm.blog.security.BlogUserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BlogUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new BlogUserDetails(user);
    }
}
