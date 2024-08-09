package com.josh.humansApp.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HumanDtoTest {

    @Test
    public void testConstructorAndGetters() {
        HumanDto humanDto = new HumanDto(1L, "John", "Doe", "John Doe", true, 30);

        assertNotNull(humanDto);

        assertEquals(1L, humanDto.getId());
        assertEquals("John", humanDto.getFirstName());
        assertEquals("Doe", humanDto.getLastName());
        assertEquals("John Doe", humanDto.getFullName());
        assertEquals(true, humanDto.isAdult());
        assertEquals(30, humanDto.getAge());
    }

    @Test
    public void testSetters() {
        HumanDto humanDto = new HumanDto();

        humanDto.setId(2L);
        humanDto.setFirstName("Jane");
        humanDto.setLastName("Smith");
        humanDto.setAge(25);
        humanDto.setAdult(true);
        humanDto.setFullName("Jane Smith");

        assertEquals(2L, humanDto.getId());
        assertEquals("Jane", humanDto.getFirstName());
        assertEquals("Smith", humanDto.getLastName());
        assertEquals("Jane Smith", humanDto.getFullName());
        assertEquals(true, humanDto.isAdult());
        assertEquals(25, humanDto.getAge());
    }
}
