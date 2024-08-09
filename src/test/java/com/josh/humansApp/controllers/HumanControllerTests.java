package com.josh.humansApp.controllers;

import com.josh.humansApp.dtos.HumanDto;
import com.josh.humansApp.services.HumanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanControllerTests {

    @Mock
    private HumanService humanService;

    @InjectMocks
    private HumanController humanController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void itShouldFetchPaginatedData(){
        Page<HumanDto> page = Mockito.mock(Page.class);
        Mockito.when(humanService.getAllHumans(1,10)).thenReturn(page);
        ResponseEntity<Page<HumanDto>> responseEntity = humanController.getAllHumans(1,10);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
    }


    @Test
    public void itShouldCreateAHuman(){
        HumanDto humanDto = new HumanDto();
        Mockito.when(humanService.createHuman(humanDto)).thenReturn(humanDto);

        ResponseEntity<HumanDto> responseEntity = humanController.createHuman(humanDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(humanDto,responseEntity.getBody());
    }

    @Test
    public void itShouldUpdateHuman(){
        HumanDto humanDto = new HumanDto();
        long id = 1L;

        Mockito.when(humanService.updateHuman(id,humanDto)).thenReturn(humanDto);

        ResponseEntity<HumanDto> responseEntity = humanController.updateHuman(id, humanDto);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(humanDto, responseEntity.getBody());
    }


    @Test
    public void itShouldFetchHumanById(){
        HumanDto humanDto = new HumanDto();
        long id = 1L;
        Mockito.when(humanService.getHuman(id)).thenReturn(humanDto);

        ResponseEntity<HumanDto> responseEntity = humanController.getHumanById(id);

        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
        assertEquals(humanDto, responseEntity.getBody());
    }

}
