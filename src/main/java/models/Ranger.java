package models;

import org.testng.annotations.Test;

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
}
