package models;


public class Animal {
    private final String name;
    private final String health;
    private final String age;
    public Animal(String name, String health, String age) {
        this.name=name;
        this.health=health;
        this.age=age;

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

}

