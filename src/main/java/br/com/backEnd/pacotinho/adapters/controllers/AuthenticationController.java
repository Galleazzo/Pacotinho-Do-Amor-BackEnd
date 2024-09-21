package br.com.backEnd.pacotinho.adapters.controllers;

import br.com.backEnd.pacotinho.adapters.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface AuthenticationController {

    ResponseEntity<?> login(UserDTO userDTO) throws Exception;

    ResponseEntity<Boolean> checkTokenValidity(String token);
}
