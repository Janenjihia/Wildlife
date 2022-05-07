package models;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

class EndangaredAnimalTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private EndangeredAnimal newAnimal() {
        return new EndangeredAnimal("Goat","Healthy","Young");
    }
}