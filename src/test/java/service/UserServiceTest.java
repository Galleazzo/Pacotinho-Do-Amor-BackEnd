package service;

import br.com.backEnd.pacotinho.core.domain.entities.User;
import br.com.backEnd.pacotinho.adapters.dtos.UserDTO;
import br.com.backEnd.pacotinho.adapters.repositories.UserRepository;
import br.com.backEnd.pacotinho.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(1);
        user.setUsername("testUser");
        user.setPassword("encodedPassword");

        userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setUsername("testUser");
        userDTO.setPassword("plainPassword");

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser_NewUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.saveUser(userDTO);

        assertNotNull(savedUser);
        assertEquals(user.getUsername(), savedUser.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testSaveUser_ExistingUser() {
        userDTO.setId(1);
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.saveUser(userDTO);

        assertNotNull(savedUser);
        assertEquals(1, savedUser.getId());
        assertEquals("testUser", savedUser.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testFindById_UserExists() {
        when(userRepository.findByIdUniq(1L)).thenReturn(user);

        UserDTO foundUserDTO = userService.findById(1L);

        assertNotNull(foundUserDTO);
        assertEquals(1, foundUserDTO.getId());
        assertEquals("testUser", foundUserDTO.getUsername());
        verify(userRepository, times(1)).findByIdUniq(1L);
    }

}
