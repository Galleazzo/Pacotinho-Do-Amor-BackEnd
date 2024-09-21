package br.com.backEnd.pacotinho.core.usecases.Animals.impl;

import br.com.backEnd.pacotinho.adapters.repositories.AnimalsRepository;
import br.com.backEnd.pacotinho.core.usecases.Animals.DeleteAnimalUseCase;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteAnimalUseCaseImpl implements DeleteAnimalUseCase {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Override
    public void deleteAnimal(Long id) throws Exception {
        try {
            this.animalsRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Erro ao deletar o animal: " + e.getMessage());
        }
    }
}
