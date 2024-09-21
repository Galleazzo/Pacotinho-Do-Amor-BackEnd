package br.com.backEnd.pacotinho.core.usecases.adopter.impl;

import br.com.backEnd.pacotinho.adapters.repositories.AdopterRepository;
import br.com.backEnd.pacotinho.core.usecases.adopter.DeleteAdopterUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DeleteAdopterUseCaseImpl implements DeleteAdopterUseCase {

    @Autowired
    private AdopterRepository adopterRepository;

    @Override
    @Transactional
    public void deleteAdopter(Long id) {
        try {
            this.adopterRepository.deleteById(id);
        }catch (Exception e) {
            throw new RuntimeException("Não foi possivel fazer a exclusao!");
        }
    }
}
