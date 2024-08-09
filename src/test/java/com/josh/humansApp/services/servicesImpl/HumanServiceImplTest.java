package com.josh.humansApp.services.servicesImpl;

import com.josh.humansApp.dtos.HumanDto;
import com.josh.humansApp.entities.Human;
import com.josh.humansApp.repositories.HumansRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class HumanServiceImplTest {

    @Mock
    private HumansRepository humansRepository;

    @InjectMocks
    private HumanServiceImpl humanService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateHuman() {
        // Create a HumanDto object
        HumanDto humanDto = new HumanDto();
        humanDto.setFirstName("Jane");
        humanDto.setLastName("Smith");
        humanDto.setAge(25);

        // Create a Human object
        Human human = new Human();
        human.setFirstName("Jane");
        human.setLastName("Smith");
        human.setAge(25);

        // Mock repository behavior
        when(humansRepository.save(any(Human.class))).thenReturn(human);

        // Call the service method
        HumanDto createdHuman = humanService.createHuman(humanDto);

        // Verify that the service method returns the correct HumanDto object
        assertEquals(humanDto.getFirstName(), createdHuman.getFirstName());
        assertEquals(humanDto.getLastName(), createdHuman.getLastName());
        assertEquals(humanDto.getAge(), createdHuman.getAge());

        // Verify that the repository save method was called
        verify(humansRepository, times(1)).save(any(Human.class));
    }
}
