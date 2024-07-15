package controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.backEnd.pacotinho.controller.AnimalsController;
import br.com.backEnd.pacotinho.model.dto.AnimalsDTO;
import br.com.backEnd.pacotinho.service.AnimalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AnimalControllerTest {

    @InjectMocks
    private AnimalsController animalsController;

    @Mock
    private AnimalsService animalsService;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Test get by id")
    @Test
    void testGetById() throws Exception {
        AnimalsDTO animalsDTO = new AnimalsDTO();
        when(this.animalsService.getById(ArgumentMatchers.anyLong())).thenReturn(animalsDTO);
        ResponseEntity<AnimalsDTO> response = this.animalsController.getById(anyLong());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(animalsDTO, response.getBody());
    }

    @DisplayName("Test get by id Error")
    @Test
    void testGetById_Error() throws Exception {
        Exception exception = new Exception();
        when(this.animalsService.getById(ArgumentMatchers.anyLong())).thenThrow(exception);
        ResponseEntity<AnimalsDTO> response = this.animalsController.getById(anyLong());

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @DisplayName("Test save new animal")
    @Test
    void testSaveNewAnimal() throws Exception {
        AnimalsDTO animalsDTO = new AnimalsDTO();
        when(this.animalsService.save(ArgumentMatchers.any(AnimalsDTO.class))).thenReturn(animalsDTO);

        MultipartFile[] multipartFiles = {};
        ResponseEntity<AnimalsDTO> response = this.animalsController.save(animalsDTO, multipartFiles);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(animalsDTO, response.getBody());
    }

    @DisplayName("Test by criteria")
    @Test
    void testGetByCriteria() {
        Page<AnimalsDTO> animalsDTOPage = Mockito.mock(Page.class);
        //Pode ser feito assim ^ ou assim ->
        //List<AnimalsDTO> animalsDTOS = new ArrayList<>();
        //Page<AnimalsDTO> animalsDTOPage = new PageImpl<>(animalsDTOS);

        when(this.animalsService.getByCriteria(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(animalsDTOPage);
        ResponseEntity<Page<AnimalsDTO>> response = this.animalsController.getByCriteria("", 0, 0, "", "");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(animalsDTOPage, response.getBody());
    }

    @DisplayName("Test delete by id")
    @Test
    void testDeletById() throws Exception {
        doNothing().when(animalsService).deleteAnimal(ArgumentMatchers.anyLong());
        animalsController.deleteById(1L);

        verify(animalsService, times(1)).deleteAnimal(anyLong());
    }

    @DisplayName("Test get all animals")
    @Test
    void testGetAllAnimals() {
        List<AnimalsDTO> animalsDTOList = new ArrayList<>();
        when(animalsService.getAll()).thenReturn(animalsDTOList);
        ResponseEntity<List<AnimalsDTO>> response = this.animalsController.getAllAnimals();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(animalsDTOList, response.getBody());
    }

    @DisplayName("Test change active animal")
    @Test
    void testChangeActive() {
        Date date = new Date();
        doNothing().when(this.animalsService).changeActive(ArgumentMatchers.anyLong(), any());
        this.animalsController.changeActive(1L, date);

        verify(this.animalsService, times(1)).changeActive(anyLong(), any());
    }
}
