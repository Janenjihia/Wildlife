package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Ranger {

    private final String name;
    private  int id;



    @Override
    public boolean equals(Object Ranger) {
        if (this == Ranger) return true;
        if (Ranger == null || getClass() != Ranger.getClass()) return false;
        Ranger ranger = (Ranger) Ranger;
        return name.equals(ranger.name);
    }

    public Ranger(String name) {
        this.name=name;
    }


    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }


//DB

    public void save() {
            String sql = "INSERT INTO rangers(name) VALUES(:name)";
            try (Connection con = DB.sql2o.open()) {
                this.id = (int) con.createQuery(sql, true)
                        .addParameter("name", this.name)
                        .executeUpdate()
                        .getKey();
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
        }
    public List<Sighting> mySightings(){
        String sql = "SELECT * FROM sightings WHERE rangerid=:id";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",this.id)
                    .executeAndFetch(Sighting.class);
        }
    }
    public void delete(){
        try(Connection con = DB.sql2o.open()){
            con.createQuery("DELETE FROM rangers WHERE id=:id")
                    .addParameter("id",this.id)
                    .executeUpdate();
        }
    }
}
