package br.com.backEnd.pacotinho.service;

import br.com.backEnd.pacotinho.model.User;
import br.com.backEnd.pacotinho.model.dto.UserDTO;
import br.com.backEnd.pacotinho.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

    public User saveUser(UserDTO userDTO){
        User user = new User();
        if(userDTO.getId() != null)
            user.setId(userDTO.getId());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(userDTO.getPassword());

        user.setUsername(userDTO.getUsername());
        user.setPassword(password);

        return repository.save(user);
    }

    public UserDTO findById(Long id){
        User user = repository.findByIdUniq(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

}