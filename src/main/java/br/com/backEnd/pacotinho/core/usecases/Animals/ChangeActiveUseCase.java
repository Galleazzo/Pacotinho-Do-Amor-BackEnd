package br.com.backEnd.pacotinho.core.usecases.Animals;

import java.util.Date;

public interface ChangeActiveUseCase {

    void changeActive(Long id, Date adoptionDate);
}
