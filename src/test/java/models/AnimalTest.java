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
    @Test
    public void getName_animalInstantiatesWithName_simba() {
        assertEquals("simba", testAnimal.getName());
    }
    @Test
    public void getHealth_animalInstantiatesWithHealth_String() {
        assertEquals("healthy", testAnimal.getHealth());
    }
    @Test
    public void getAge_animalInstantiatesWithAge_String() {
        assertEquals("newborn", testAnimal.getAge());
    }
    @Test
    public void equals_returnsTrueIfNameAndHealthAndAgeAreSame_true() {
        Animal firstAnimal = new Animal("simba", "healthy","newborn");
        Animal anotherAnimal = new Animal("tinga", "healthy","adult");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

}