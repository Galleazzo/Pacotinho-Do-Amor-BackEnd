package controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.backEnd.pacotinho.controller.AdopterController;
import br.com.backEnd.pacotinho.model.dto.AdopterDTO;
import br.com.backEnd.pacotinho.service.AdopterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class AdopterControllerTest {

    @Mock
    private AdopterService adopterService;

    @InjectMocks
    private AdopterController adopterController;

    private AdopterDTO adopterDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        adopterDTO = new AdopterDTO();
    }

    @Test
    @DisplayName("Test creation of a new adopter")
    public void testCreateAdopter() {
        when(adopterService.createAdopter(any(AdopterDTO.class))).thenReturn(adopterDTO);

        ResponseEntity<AdopterDTO> response = adopterController.createAdopter(adopterDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adopterDTO, response.getBody());
        verify(adopterService, times(1)).createAdopter(any(AdopterDTO.class));
    }

    @Test
    @DisplayName("Test updating an existing adopter")
    public void testUpdateAdopter() {
        when(adopterService.updateAdopter(anyLong(), any(AdopterDTO.class))).thenReturn(adopterDTO);

        ResponseEntity<AdopterDTO> response = adopterController.updateAdopter(1L, adopterDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adopterDTO, response.getBody());
        verify(adopterService, times(1)).updateAdopter(anyLong(), any(AdopterDTO.class));
    }

    @Test
    @DisplayName("Test deletion of an adopter")
    public void testDeleteAdopter() {
        doNothing().when(adopterService).deleteAdopter(anyLong());

        ResponseEntity<Void> response = adopterController.deleteAdopter(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(adopterService, times(1)).deleteAdopter(anyLong());
    }

    @Test
    @DisplayName("Test fetching an adopter by ID")
    public void testGetAdopterById() {
        when(adopterService.getAdopterById(anyLong())).thenReturn(adopterDTO);

        ResponseEntity<AdopterDTO> response = adopterController.getAdopterById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adopterDTO, response.getBody());
        verify(adopterService, times(1)).getAdopterById(anyLong());
    }

    @Test
    @DisplayName("Test adopting an animal")
    public void testAdoptAnimal() {
        when(adopterService.adoptAnimal(anyLong(), anyLong())).thenReturn(adopterDTO);

        ResponseEntity<AdopterDTO> response = adopterController.adoptAnimal(1L, 2L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adopterDTO, response.getBody());
        verify(adopterService, times(1)).adoptAnimal(anyLong(), anyLong());
    }
}