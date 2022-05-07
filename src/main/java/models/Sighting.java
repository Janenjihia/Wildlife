package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class Sighting {
    private String animalName;
    private String location;
    private Timestamp timestamp;
    private int rangerid;

    public Sighting(String animalName, String location, int rangerid) {
        this.animalName = animalName;
        this.location = location.trim();
        this.timestamp = new Timestamp(new Date().getTime());
        this.rangerid = rangerid;
}

    public String getAnimalName() {
        return animalName;
    }

    public String getLocation() {
        return location;
    }

    public int getRangerid() {
        return rangerid;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    public String getReadableTimestamp(){
        return DateFormat.getDateTimeInstance().format(getTimestamp());
    }


    public int getId() {
        return getId();
    }
}
