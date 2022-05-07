package models;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test","nick","00000000");
    }
@Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalQuery = "DELETE FROM animals;";
            con.createQuery(deleteAnimalQuery).executeUpdate();

        }
    }
}