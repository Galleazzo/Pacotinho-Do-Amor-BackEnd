package br.com.backEnd.pacotinho.adapters.controllers;

import br.com.backEnd.pacotinho.adapters.dtos.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {

    void saveUser(UserDTO user);

    UserDTO findById(Long id);
}
