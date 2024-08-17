package controller;

import br.com.backEnd.pacotinho.controller.AutenticationController;
import br.com.backEnd.pacotinho.model.User;
import br.com.backEnd.pacotinho.model.dto.UserDTO;
import br.com.backEnd.pacotinho.model.dto.tokenDTO;
import br.com.backEnd.pacotinho.service.TokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AutenticationControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private AutenticationController autenticationController;

    private UserDTO userDTO;
    private Authentication authentication;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userDTO = new UserDTO();
        userDTO.setUsername("testUser");
        userDTO.setPassword("testPass");

        User userPrincipal = new User();
        userPrincipal.setUsername("testUser");
        userPrincipal.setPassword("testPass");
        authentication = new UsernamePasswordAuthenticationToken(userPrincipal, null, new ArrayList<>());
    }

    @Test
    @DisplayName("Test check token validity with valid token")
    public void testCheckTokenValidity_ValidToken() {
        when(tokenService.cheakValidToken(anyString())).thenReturn(true);

        ResponseEntity<Boolean> response = autenticationController.checkTokenValidity("validToken");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(true, response.getBody());
        verify(tokenService, times(1)).cheakValidToken("validToken");
    }

    @Test
    @DisplayName("Test check token validity with invalid token")
    public void testCheckTokenValidity_InvalidToken() {
        when(tokenService.cheakValidToken(anyString())).thenThrow(new RuntimeException("Invalid Token"));

        ResponseEntity<Boolean> response = autenticationController.checkTokenValidity("invalidToken");

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals(false, response.getBody());
        verify(tokenService, times(1)).cheakValidToken("invalidToken");
    }
}