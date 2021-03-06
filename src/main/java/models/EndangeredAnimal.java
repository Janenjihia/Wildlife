package models;

import org.sql2o.Connection;
import java.util.List;

public class EndangeredAnimal extends Animal{
    private static final String DB_TYPE = "Endangered";
    private  String name;
    private  String health;
    private  String age;
    private  String type;


    public EndangeredAnimal(String name, String health, String age) {
        super("matata", "health", "young");
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = DB_TYPE;
    }

//    DB

    public static List<EndangeredAnimal> all(){
        String sql = "SELECT * FROM animals where type=:type";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("type",DB_TYPE)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal find(int searchId){
        String sql = "SELECT * FROM animals where (id=:id AND type=:type)";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id",searchId)
                    .addParameter("type",DB_TYPE)
                    .executeAndFetchFirst(EndangeredAnimal.class);
        }
    }
}
