package br.com.backEnd.pacotinho.core.usecases.Animals;

import br.com.backEnd.pacotinho.adapters.web.dtos.AnimalsDTO;
import org.springframework.data.domain.Page;

public interface GetByCriteriaUseCase {

    Page<AnimalsDTO> getByCriteria(String name, Integer page, Integer pageSize, String sort, String order);
}
