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
}


