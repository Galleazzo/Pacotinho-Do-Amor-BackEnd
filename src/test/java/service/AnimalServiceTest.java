package service;

import br.com.backEnd.pacotinho.repository.AnimalsRepository;
import br.com.backEnd.pacotinho.service.AnimalsService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @InjectMocks
    private AnimalsService animalsService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private AnimalsRepository animalsRepository;


}
