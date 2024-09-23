package br.com.backEnd.pacotinho.infrastructure.security;

import br.com.backEnd.pacotinho.core.domain.entities.User;
import br.com.backEnd.pacotinho.adapters.dtos.UserDTO;
import br.com.backEnd.pacotinho.adapters.repositories.UserRepository;
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
