package com.finbank.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User register(String username, String password) {
        if(userRepository.findByUsername(username).isPresent()){
            throw new RuntimeException("User already exists");
        }
        User user = User.builder()
                .username(username)
                .password(password)
                .role("SAMPLE")
                .build();

        return userRepository.save(user);
    }
}
