package models;


import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
@SuppressWarnings("ALL")


public class Animal {
    private String name;
    private  String health;
    private  String age;
    private int id;
    private String type;

    public Animal(String name, String health, String age) {
        this.name=name;
        this.health=health;
        this.age=age;
        this.type=type;

    }

    @Override
    public boolean equals(Object otherAnimal) {
        if (this == otherAnimal) return true;
        if (otherAnimal == null || getClass() != otherAnimal.getClass()) return false;
        Animal newAnimal = (Animal) otherAnimal;
        return  this.getName().equals(newAnimal.getName()) &&
                this.getName().equals(newAnimal.getName()) &&
                this.getAge().equals(newAnimal.getAge()) &&
                this.getType().equals(newAnimal.getType());
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

    public String setName() {
        return name;
    }

    public String setHealth() {
        return health;
    }

    public String setType() {
        return type;
    }
    public String getType() {
        return type;
    }
    public String setAge() {
        return age;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


//DB

    public static List<String> allAnimalNames() {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT name FROM animals")
                    .executeAndFetch(String.class);
        }
    }

    public void save(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals(name,health, age, type) values (:name,:health,:age,:type)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age",this.age)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
