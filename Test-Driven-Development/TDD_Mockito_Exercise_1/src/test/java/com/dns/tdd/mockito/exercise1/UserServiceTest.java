package com.dns.tdd.mockito.exercise1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserNameWhenUserExists() {
        User user = new User(1L, "John Doe", "john@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        String userName = userService.getUserName(1L);
        assertEquals("John Doe", userName);
    }

    @Test
    public void testGetUserNameWhenUserNotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.getUserName(99L));
    }
}
