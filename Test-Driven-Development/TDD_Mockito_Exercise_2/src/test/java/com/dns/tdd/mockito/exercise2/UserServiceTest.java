package com.dns.tdd.mockito.exercise2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @Test
    public void testGetUserNameWhenUserExists() {
        User user = new User(1L, "John Doe", "john@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        String userName = userService.getUserName(1L);
        assertEquals("John Doe", userName);
    }

    @Test
    public void testRegisterUserSavesAndReturnsUser() {
        User user = new User(1L, "Jane Doe", "jane@example.com");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.registerUser(1L, "Jane Doe", "jane@example.com");

        assertEquals("Jane Doe", result.getName());
        verify(userRepository).save(any(User.class));
    }

    @Test
    public void testRegisterUserCapturesArguments() {
        when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArgument(0));

        userService.registerUser(2L, "Alice", "alice@example.com");

        verify(userRepository).save(userCaptor.capture());
        User captured = userCaptor.getValue();
        assertEquals(2L, captured.getId());
        assertEquals("Alice", captured.getName());
        assertEquals("alice@example.com", captured.getEmail());
    }
}
