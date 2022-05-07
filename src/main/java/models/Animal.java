package models;


import org.sql2o.Connection;

import java.util.List;

public class Animal {
    private final String name;
    private final String health;
    private final String age;
    public Animal(String name, String health, String age) {
        this.name=name;
        this.health=health;
        this.age=age;

    }
    @Override
    public boolean equals(Object otherAnimal) {
        if (this == otherAnimal) return true;
        if (otherAnimal == null || getClass() != otherAnimal.getClass()) return false;
        Animal newAnimal = (Animal) otherAnimal;
        return  this.getName().equals(newAnimal.getName()) &&
                this.getName().equals(newAnimal.getName()) &&
                this.getAge().equals(newAnimal.getAge());
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

    public String setAge() {
        return age;
    }


//DB

    public static List<String> allAnimalNames() {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT name FROM animals")
                    .executeAndFetch(String.class);
        }
    }
}
