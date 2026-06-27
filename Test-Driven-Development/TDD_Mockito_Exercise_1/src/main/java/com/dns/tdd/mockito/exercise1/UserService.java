package com.dns.tdd.mockito.exercise1;

import java.util.Optional;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(User::getName)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
