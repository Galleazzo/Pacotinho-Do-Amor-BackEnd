package service;

import br.com.backEnd.pacotinho.model.User;
import br.com.backEnd.pacotinho.repository.UserRepository;
import br.com.backEnd.pacotinho.service.AutenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AutenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AutenticationService autenticationService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setUsername("testUser");
        user.setPassword("password123");

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoadUserByUsername_UserExists() {
        when(userRepository.findByUsername("testUser")).thenReturn(user);

        UserDetails userDetails = autenticationService.loadUserByUsername("testUser");

        assertNotNull(userDetails);
        assertEquals("testUser", userDetails.getUsername());
        verify(userRepository, times(1)).findByUsername("testUser");
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        String msg = "User not found";
        String returnedMsg = "";
        when(userRepository.findByUsername(anyString())).thenThrow(UsernameNotFoundException.class);

        try{
            this.autenticationService.loadUserByUsername("unknownUser");
        } catch (UsernameNotFoundException e) {
            returnedMsg = e.getMessage();
        }

        assertEquals(msg, returnedMsg);

    }
}
