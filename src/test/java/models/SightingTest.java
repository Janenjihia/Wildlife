package models;
import models.Sighting;
import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;


class SightingTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private Sighting newSighting(){
        return new Sighting("Rhino","Zone-B",5);
    }
    private Sighting newSighting2(){return new Sighting("Deer","Zone-B",1);}
    @Test
    public void sighting_instantiatesCorrectly(){
        Sighting sighting = newSighting();
        assertTrue(sighting instanceof Sighting);
    }
    @Test
    public void getAnimalId_returnAnimalName_true(){
        Sighting sighting = newSighting();
        assertEquals("Rhino",sighting.getAnimalName());
    }
    @Test
    public void getLocation_returnSightingLocation_true(){
        Sighting sighting = newSighting();
        assertEquals("Zone-B",sighting.getLocation());
    }
    @Test
    public void getRangerId_returnRangerId_true(){
        Sighting sighting = newSighting();
        assertEquals(1,sighting.getRangerid());
    }
    @Test
    public void getTimestamp_returnRangerId_true(){
        Sighting sighting = newSighting();
        Timestamp testTimestamp = new Timestamp(new Date().getTime());
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        assertEquals(dateFormat.format(testTimestamp),dateFormat.format(sighting.getTimestamp()));
    }
//    @Test
//    public void save_savesSightingIntoDB_true(){
//        Sighting sighting = newSighting();
//        int idBefore = sighting.getId();
//        sighting.save();
//        assertNotEquals(idBefore,sighting.getId());
//    }
}