package service;

import br.com.backEnd.pacotinho.model.Adopter;
import br.com.backEnd.pacotinho.model.Animals;
import br.com.backEnd.pacotinho.model.dto.AddressDTO;
import br.com.backEnd.pacotinho.model.dto.AdopterDTO;
import br.com.backEnd.pacotinho.model.dto.ContactDTO;
import br.com.backEnd.pacotinho.repository.AdopterRepository;
import br.com.backEnd.pacotinho.repository.AnimalsRepository;
import br.com.backEnd.pacotinho.service.AdopterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdopterServiceTest {

    @Mock
    private AdopterRepository adopterRepository;

    @Mock
    private AnimalsRepository animalsRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private AdopterService adopterService;

    private Adopter adopter;
    private AdopterDTO adopterDTO;
    private Animals animal;

    @BeforeEach
    public void setUp() {
        adopter = new Adopter();
        adopter.setId(1L);
        adopter.setFullName("John Doe");

        adopterDTO = new AdopterDTO();
        adopterDTO.setId(1L);
        adopterDTO.setFullName("John Doe");

        animal = new Animals();
        animal.setId(1L);
        animal.setName("Dog");

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAdopter() {
        when(modelMapper.map(adopterDTO, Adopter.class)).thenReturn(adopter);
        when(adopterRepository.save(any(Adopter.class))).thenReturn(adopter);
        when(modelMapper.map(adopter, AdopterDTO.class)).thenReturn(adopterDTO);

        AdopterDTO result = adopterService.createAdopter(adopterDTO);

        assertNotNull(result);
        assertEquals(adopterDTO.getFullName(), result.getFullName());
        verify(adopterRepository, times(1)).save(adopter);
    }

    @Test
    public void testUpdateAdopter() {
        AdopterDTO dto = new AdopterDTO();
        dto.setId(1L);
        dto.setFullName("John Doe");
        dto.setDateOfBirth("10/10/2003");
        dto.setResidenceType("casa");
        dto.setAllowsPets(true);
        dto.setPreferredAnimalType("cao");
        dto.setPreferredAnimalAge("0");
        dto.setPreferredAnimalGender("m");
        dto.setAddress(new AddressDTO());
        dto.setAnimals(new HashSet<>());
        dto.setContact(new ContactDTO());
        dto.setPartner(new AdopterDTO());

        when(adopterRepository.findById(1L)).thenReturn(Optional.of(adopter));
        when(adopterRepository.save(any(Adopter.class))).thenReturn(adopter);
        when(modelMapper.map(adopter, AdopterDTO.class)).thenReturn(adopterDTO);

        AdopterDTO result = adopterService.updateAdopter(1L, adopterDTO);

        assertNotNull(result);
        assertEquals(adopterDTO.getFullName(), result.getFullName());
        verify(adopterRepository, times(1)).findById(1L);
        verify(adopterRepository, times(1)).save(adopter);
    }


    @Test
    public void testUpdateAdopterNotFound() {
        when(adopterRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            adopterService.updateAdopter(1L, adopterDTO);
        });

        assertEquals("Adopter not found with id 1", exception.getMessage());
        verify(adopterRepository, times(1)).findById(1L);
        verify(adopterRepository, never()).save(any(Adopter.class));
    }

    @Test
    public void testDeleteAdopter() {
        adopterService.deleteAdopter(1L);

        verify(adopterRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetAdopterById() {
        when(adopterRepository.findById(1L)).thenReturn(Optional.of(adopter));
        when(modelMapper.map(adopter, AdopterDTO.class)).thenReturn(adopterDTO);

        AdopterDTO result = adopterService.getAdopterById(1L);

        assertNotNull(result);
        assertEquals(adopterDTO.getFullName(), result.getFullName());
        verify(adopterRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetAdopterByIdNotFound() {
        when(adopterRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            adopterService.getAdopterById(1L);
        });

        assertEquals("Adopter not found with id 1", exception.getMessage());
        verify(adopterRepository, times(1)).findById(1L);
    }

    @Test
    public void testAdoptAnimal() {
        when(adopterRepository.findById(1L)).thenReturn(Optional.of(adopter));
        when(animalsRepository.findById(1L)).thenReturn(Optional.of(animal));
        when(modelMapper.map(adopter, AdopterDTO.class)).thenReturn(adopterDTO);
        when(adopterRepository.save(any(Adopter.class))).thenReturn(adopter);
        when(animalsRepository.save(any(Animals.class))).thenReturn(animal);

        AdopterDTO result = adopterService.adoptAnimal(1L, 1L);

        assertNotNull(result);
        assertTrue(adopter.getAnimals().contains(animal));
        assertTrue(animal.getAdopterPeople().contains(adopter));
        verify(adopterRepository, times(1)).findById(1L);
        verify(animalsRepository, times(1)).findById(1L);
        verify(adopterRepository, times(1)).save(adopter);
        verify(animalsRepository, times(1)).save(animal);
    }

    @Test
    public void testAdoptAnimalWithMaxAdopters() {
        when(adopterRepository.findById(1L)).thenReturn(Optional.of(adopter));
        when(animalsRepository.findById(1L)).thenReturn(Optional.of(animal));
        animal.setAdopterPeople(Set.of(new Adopter(), new Adopter())); // Animal já tem 2 adotantes

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            adopterService.adoptAnimal(1L, 1L);
        });

        assertEquals("Animal already has maximum number of adopters", exception.getMessage());
        verify(adopterRepository, times(1)).findById(1L);
        verify(animalsRepository, times(1)).findById(1L);
        verify(adopterRepository, never()).save(any(Adopter.class));
        verify(animalsRepository, never()).save(any(Animals.class));
    }

    @Test
    public void testAdoptAnimalAdopterNotFound() {
        when(adopterRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            adopterService.adoptAnimal(1L, 1L);
        });

        assertEquals("Adopter not found with id 1", exception.getMessage());
        verify(adopterRepository, times(1)).findById(1L);
        verify(animalsRepository, never()).findById(1L);
        verify(adopterRepository, never()).save(any(Adopter.class));
        verify(animalsRepository, never()).save(any(Animals.class));
    }

    @Test
    public void testAdoptAnimalAnimalNotFound() {
        when(adopterRepository.findById(1L)).thenReturn(Optional.of(adopter));
        when(animalsRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            adopterService.adoptAnimal(1L, 1L);
        });

        assertEquals("Animal not found with id 1", exception.getMessage());
        verify(adopterRepository, times(1)).findById(1L);
        verify(animalsRepository, times(1)).findById(1L);
        verify(adopterRepository, never()).save(any(Adopter.class));
        verify(animalsRepository, never()).save(any(Animals.class));
    }
}
