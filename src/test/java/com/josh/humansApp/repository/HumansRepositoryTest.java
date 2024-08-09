//package com.josh.humansApp.repository;
//
//import com.josh.humansApp.entities.Human;
//import com.josh.humansApp.repositories.HumansRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//public class HumansRepositoryTest {
//
//    @Autowired
//    private HumansRepository humansRepository;
//
//    @Test
//    public void testSaveHuman() {
//        // Create a Human object
//        Human human = new Human();
//        human.setFirstName("Jane");
//        human.setLastName("Smith");
//        human.setAge(25);
//        human.setAdult(true);
//        human.setFullName("Jane Smith");
//
//        // Save the Human object using the repository
//        Human savedHuman = humansRepository.save(human);
//
//        // Verify that the saved Human object has an ID assigned
//        assertTrue(savedHuman.getId() != null && savedHuman.getId() > 0);
//    }
//
//    @Test
//    public void testFindById() {
//        // Create a Human object
//        Human human = new Human();
//        human.setFirstName("Jane");
//        human.setLastName("Smith");
//        human.setAge(25);
//        human.setAdult(true);
//        human.setFullName("Jane Smith");
//
//        // Save the Human object using the repository
//        Human savedHuman = humansRepository.save(human);
//
//        // Retrieve the Human object by ID using the repository
//        Optional<Human> optionalHuman = humansRepository.findById(savedHuman.getId());
//
//        // Verify that the retrieved Human object is present and matches the saved Human object
//        assertTrue(optionalHuman.isPresent());
//        Human retrievedHuman = optionalHuman.get();
//        assertEquals(savedHuman.getId(), retrievedHuman.getId());
//        assertEquals(savedHuman.getFirstName(), retrievedHuman.getFirstName());
//        assertEquals(savedHuman.getLastName(), retrievedHuman.getLastName());
//        assertEquals(savedHuman.getAge(), retrievedHuman.getAge());
//        assertEquals(savedHuman.isAdult(), retrievedHuman.isAdult());
//        assertEquals(savedHuman.getFullName(), retrievedHuman.getFullName());
//    }
//}
