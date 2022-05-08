package models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Rule;
import org.junit.Test;
class RangerTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private Ranger newRanger() {
        return new Ranger("Mwangi");
    }

    @Test
    public void ranger_instantiatesCorrectly(){
        Ranger ranger = newRanger();
        assertTrue(ranger instanceof Ranger);
    }
}