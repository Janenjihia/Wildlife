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



//DB

    public void save(){
        String sql = "INSERT INTO sightings(animalname,location,timestamp,rangerid) values (:animalName,:location,:timestamp,:rangerid)";
        try(Connection con = DB.sql2o.open()){
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalName",this.animalName)
                    .addParameter("location",this.location)
                    .addParameter("timestamp",this.timestamp)
                    .addParameter("rangerid",this.rangerid)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    public String getRangerName(){
        return Ranger.find(rangerid).getName();
    }

    public static List<Sighting> all(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings")
                    .executeAndFetch(Sighting.class);
        }
    }

    public static Sighting find(int searchId){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings WHERE id=:id")
                    .addParameter("id",searchId)
                    .executeAndFetchFirst(Sighting.class);
        }
    }

    public static List<String> getAllLocations(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT location FROM sightings")
                    .executeAndFetch(String.class);
        }
    }

    public static List<Sighting> getAllSightingsInLocation(String locationFilter){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings where location = :location")
                    .addParameter("location",locationFilter)
                    .executeAndFetch(Sighting.class);
        }
    }