package models;

import org.sql2o.Connection;

import java.util.List;

public class NormalAnimal  {

    private static final String DB_TYPE = "Not Endangered";
    private final String name;
    private final String health;
    private final String age;
    private final String type;
    private int id;

    public NormalAnimal(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = DB_TYPE;

    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public String getType() {
        return DB_TYPE;
    }
    public short getId() {
        return id;
    }

//    db

    public static List<NormalAnimal> all(){
        String sql = "SELECT * FROM animals where type=:type";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("type",DB_TYPE)
                    .executeAndFetch(NormalAnimal.class);
        }
    }

    public static NormalAnimal find(int searchId){
        String sql = "SELECT * FROM animals where (id=:id AND type=:type)";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id",searchId)
                    .addParameter("type",DB_TYPE)
                    .executeAndFetchFirst(NormalAnimal.class);
        }
    }


}
