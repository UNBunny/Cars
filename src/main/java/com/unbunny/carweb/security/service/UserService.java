package com.unbunny.carweb.security.service;

import com.unbunny.carweb.models.user.User;
import com.unbunny.carweb.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Admin not found: " + username));
    }

    public User createAdmin(String username, String password, String email) {
        User admin = new User(
                username,
                passwordEncoder.encode(password),
                email,
                new HashSet<>(Set.of("ROLE_ADMIN"))
        );
        return userRepository.save(admin);
    }

}
