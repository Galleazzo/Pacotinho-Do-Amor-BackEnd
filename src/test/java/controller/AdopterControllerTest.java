package controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.backEnd.pacotinho.controller.AdopterController;
import br.com.backEnd.pacotinho.model.dto.AdopterDTO;
import br.com.backEnd.pacotinho.service.AdopterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class AdopterControllerTest {

    @InjectMocks
    private AdopterController adopterController;

    @Mock
    private AdopterService adopterService;

    @DisplayName("Test create adopter")
    @Test
    void testCreateAdopter() {
        AdopterDTO adopterDTO = new AdopterDTO();
        when(this.adopterService.createAdopter(ArgumentMatchers.any(AdopterDTO.class))).thenReturn(adopterDTO);
        ResponseEntity<AdopterDTO> response = this.adopterController.createAdopter(adopterDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(adopterDTO, response.getBody());
    }

    @DisplayName("Test update adopter")
    @Test
    void testUpdateAdopter() {
        AdopterDTO adopterDTO = new AdopterDTO();
        when(this.adopterService.updateAdopter(ArgumentMatchers.anyLong(), ArgumentMatchers.any(AdopterDTO.class))).thenReturn(adopterDTO);
        ResponseEntity<AdopterDTO> response = this.adopterController.updateAdopter(0L, adopterDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(adopterDTO, response.getBody());
    }

    @DisplayName("Test delete adopter")
    @Test
    void testDeleteAdopter() {

    }
}