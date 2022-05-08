package models;

import org.testng.annotations.Test;

public class Ranger {

    private final String name;
    private  int id;


    public Ranger(String name) {
        this.name=name;
    }


    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
