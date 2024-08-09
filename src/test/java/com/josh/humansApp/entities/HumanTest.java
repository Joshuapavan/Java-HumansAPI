package com.josh.humansApp.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HumanTest {

    @Test
    public void testConstructorAndGetters() {
        Human human = new Human(1L, "John", "Doe", 30, true, "John Doe");

        assertNotNull(human);

        assertEquals(1L, human.getId());
        assertEquals("John", human.getFirstName());
        assertEquals("Doe", human.getLastName());
        assertEquals(30, human.getAge());
        assertEquals(true, human.isAdult());
        assertEquals("John Doe", human.getFullName());
    }

    @Test
    public void testSetters() {
        Human human = new Human();

        human.setId(2L);
        human.setFirstName("Jane");
        human.setLastName("Smith");
        human.setAge(25);
        human.setAdult(true);
        human.setFullName("Jane Smith");

        assertEquals(2L, human.getId());
        assertEquals("Jane", human.getFirstName());
        assertEquals("Smith", human.getLastName());
        assertEquals(25, human.getAge());
        assertEquals(true, human.isAdult());
        assertEquals("Jane Smith", human.getFullName());
    }
}
