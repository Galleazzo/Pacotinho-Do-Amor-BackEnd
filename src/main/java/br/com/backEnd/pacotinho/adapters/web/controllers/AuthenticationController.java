package br.com.backEnd.pacotinho.adapters.web.controllers;

import br.com.backEnd.pacotinho.adapters.web.dtos.UserDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {

    ResponseEntity<?> login(UserDTO userDTO) throws Exception;

    ResponseEntity<Boolean> checkTokenValidity(String token);
}
