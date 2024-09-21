package br.com.backEnd.pacotinho.core.usecases.authenticator.impl;

import br.com.backEnd.pacotinho.adapters.repositories.UserRepository;
import br.com.backEnd.pacotinho.core.usecases.authenticator.LoadUserByUsernameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoadUserByUsernameUseCaseImpl implements LoadUserByUsernameUseCase {

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
