package br.com.backEnd.pacotinho.adapters.controllers.impl;

import br.com.backEnd.pacotinho.adapters.controllers.UserController;
import br.com.backEnd.pacotinho.adapters.dtos.UserDTO;
import br.com.backEnd.pacotinho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService service;

    @Override
    @PostMapping(path = "/newExternalUser", produces = "application/json", consumes = "application/json")
    public void saveUser(@RequestBody UserDTO user){
        try{
            this.service.saveUser(user);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id){
        return service.findById(id);
    }
}