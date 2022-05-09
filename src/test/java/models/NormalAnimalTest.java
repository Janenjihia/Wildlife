package models;
import org.junit.Rule;
import org.sql2o.Connection;
import org.testng.annotations.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NormalAnimalTest{
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private NormalAnimal newAnimal() {
        return new NormalAnimal("Tiger","Healthy","Young");
    }
    @Test
    public void animal_instantiatesCorrectly_true(){
        NormalAnimal normalAnimal = newAnimal();
        assertTrue(normalAnimal instanceof NormalAnimal);
    }
    @Test
    public void getName_returnAnimalsName(){
        NormalAnimal normalAnimal = newAnimal();
        assertEquals("Tiger", normalAnimal.getName());
    }

    @Test
    public void getHealth_returnAnimalsHealth(){
        NormalAnimal normalAnimal = newAnimal();
        assertEquals("Healthy", normalAnimal.getHealth());
    }

    @Test
    public void getAge_returnAnimalsAge(){
        NormalAnimal normalAnimal = newAnimal();
        assertEquals("Young", normalAnimal.getAge());
    }

    @Test
    public void getStatus_returnAnimalsStatus(){
        NormalAnimal normalAnimal = newAnimal();
        assertEquals("Not Endangered", normalAnimal.getType());
    }

    @Test
    public void save_savedToDb_int(){
        NormalAnimal normalAnimal = newAnimal();
        normalAnimal.save();
        assertEquals(normalAnimal.getId(),NormalAnimal.all().get(0).getId());
    }

    @Test
    public void find_locateNormalAnimal_Name(){
        NormalAnimal normalAnimal = newAnimal();
        normalAnimal.save();
        NormalAnimal foundAnimal = NormalAnimal.find(normalAnimal.getId());
        assertTrue(normalAnimal.equals(foundAnimal));
    }
}


