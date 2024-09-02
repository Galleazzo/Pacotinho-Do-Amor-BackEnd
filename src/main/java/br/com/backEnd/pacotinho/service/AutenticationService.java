package br.com.backEnd.pacotinho.service;

import br.com.backEnd.pacotinho.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            return this.userRepository.findByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
