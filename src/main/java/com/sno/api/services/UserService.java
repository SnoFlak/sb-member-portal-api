package com.sno.api.services;

import com.sno.api.dto.UserRegistrationRequest;
import com.sno.api.dto.UserResponse;
import com.sno.api.entries.UserEntry;
import com.sno.api.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntry createUser(UserRegistrationRequest req) {
        UserEntry user = new UserEntry();
        user.setEmail(req.email());

        user.setPassword(passwordEncoder.encode(req.password()));

        return userRepository.save(user);
    }

    public UserEntry getUser(UUID publicId) {
        return userRepository.findByPublicId(publicId);
    }

    public UserResponse loginUser(UserRegistrationRequest req) throws Exception {
        UserEntry user = userRepository.findByEmail(req.email());
        if (user == null) {
            throw new Exception("Invalid Credentials");
        }

        if (!passwordEncoder.matches(req.password(), user.getPassword())){
            throw new Exception("Invalid Credentials");
        }

        return new UserResponse(user.getPublicId(), user.getEmail());
    }
}
