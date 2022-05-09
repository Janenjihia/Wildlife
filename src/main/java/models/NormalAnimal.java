package models;

public class NormalAnimal  {

    private static final String DB_TYPE = "Not Endangered";
    private final String name;
    private final String health;
    private final String age;
    private final String type;

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
}
