package com.sno.api.services;

import com.sno.api.entries.UserEntry;
import com.sno.api.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntry createUser(String email, String rawPassword) {
        UserEntry user = new UserEntry();
        user.setEmail(email);

        user.setPassword(passwordEncoder.encode(rawPassword));

        return userRepository.save(user);
    }

    public UserEntry getUser(UUID publicId) {
        return userRepository.findByPublicId(publicId);
    }
}
