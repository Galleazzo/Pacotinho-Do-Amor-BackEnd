package br.com.backEnd.pacotinho.adapters.web.controllers;

import br.com.backEnd.pacotinho.adapters.web.dtos.UserDTO;

public interface UserController {

    void saveUser(UserDTO user);

    UserDTO findById(Long id);
}
