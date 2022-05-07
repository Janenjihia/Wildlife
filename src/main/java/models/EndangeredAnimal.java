package models;
import org.sql2o.Connection;
import java.util.List;

public class EndangaredAnimal extends Animal{
    private static final String DB_TYPE = "Endangered";
    private  String name;
    private  String health;
    private  String age;
    private  String type;


    public EndangaredAnimal(String name, String health, String age) {
        super("matata", "health", "young");
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = DB_TYPE;
    }
}
