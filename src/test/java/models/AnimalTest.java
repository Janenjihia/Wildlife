package models;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal testAnimal = new Animal("simba", "healthy","newborn");

//Test to confirm animal instantiates correctly
@Test
public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("simba", "healthy","newborn");
    assertEquals(true, testAnimal instanceof Animal);
}

}