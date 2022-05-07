package models;

import org.junit.Test;

import static models.Animal.*;
import static org.junit.jupiter.api.Assertions.*;
import org.sql2o.*;


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
    public void setName_animalInstantiatesWithName_simba() {
        assertEquals("simba", testAnimal.setName());
    }
    @Test
    public void setHealth_animalInstantiatesWithHealth_String() {
        assertEquals("healthy", testAnimal.setHealth());
    }
    @Test
    public void setAge_animalInstantiatesWithAge_String() {
        assertEquals("newborn", testAnimal.setAge());
    }
    @Test
    public void equals_returnsTrueIfNameAndHealthAndAgeAreSame_true() {
        Animal firstAnimal = new Animal("simba", "healthy","newborn");
        Animal anotherAnimal = new Animal("tinga", "healthy","adult");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_assignsIdToObject() {
        testAnimal.save();
        Animal savedAnimal = all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

}