package controller;

import br.com.backEnd.pacotinho.controller.UserController;
import br.com.backEnd.pacotinho.model.dto.UserDTO;
import br.com.backEnd.pacotinho.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UserDTO userDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userDTO = new UserDTO();
        // Initialize userDTO with necessary fields here
    }


    @Test
    @DisplayName("Test saving a new external user with error")
    public void testSaveUser_Error() {
        doThrow(new RuntimeException("Error saving user")).when(userService).saveUser(any(UserDTO.class));

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            userController.saveUser(userDTO);
        });

        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        assertEquals("Error saving user", exception.getReason());
        verify(userService, times(1)).saveUser(any(UserDTO.class));
    }

    @Test
    @DisplayName("Test finding a user by ID")
    public void testFindById() {
        when(userService.findById(anyLong())).thenReturn(userDTO);

        UserDTO result = userController.findById(1L);

        assertEquals(userDTO, result);
        verify(userService, times(1)).findById(anyLong());
    }
}