package com.dns.tdd.mockito.exercise2;

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

    public User registerUser(Long id, String name, String email) {
        User user = new User(id, name, email);
        return userRepository.save(user);
    }
}
