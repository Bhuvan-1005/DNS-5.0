package com.dns.tdd.mockito.exercise1;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    User save(User user);
}
