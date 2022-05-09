import models.Sighting;
import spark.ModelAndView;
import spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import static java.util.Collections.get;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

    }

        //get: Homepage
        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> allSightings = Sighting.all();
            model.put("sightings", allSightings);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());
    }

