import models.EndangeredAnimal;
import models.NormalAnimal;
import models.Ranger;
import models.Sighting;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        int port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);

    }

        //root route
        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> allSightings = Sighting.all();
            model.put("sightings", allSightings);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

//     endangered animals


    get("/animals/endangered",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("endangered", EndangeredAnimal.all());
        return new ModelAndView(model,"endangered-animals.hbs.hbs");
    },new HandlebarsTemplateEngine());

//    non-endangeredanimals


    get("/animals/normal",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("normal", NormalAnimal.all());
        return new ModelAndView(model,"normal-animals.hbs");
    },new HandlebarsTemplateEngine());

    // New Sighting Form

    get("/sighting/new",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("sightings", Sighting.all());
        return new ModelAndView(model,"sighting-form.hbs");
    },new HandlebarsTemplateEngine());

    //Sighting Submission
    post("/sighting/new",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        String rangerName = request.queryParams("rangerName").trim();
        String animalName = request.queryParams("animalName").trim();
        String animalAge = request.queryParams("animalAge").trim();
        String animalHealth = request.queryParams("animalHealth").trim();
        String location = request.queryParams("location").trim();
        String animalType = request.queryParams("animalType").trim();

        Ranger newRanger = new Ranger(rangerName);
        newRanger.save();

        if(animalType.equalsIgnoreCase("Endangered")){
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName,animalHealth,animalAge);
            endangeredAnimal.save();
            Sighting newSighting = new Sighting(endangeredAnimal.getName(),location,newRanger.getId());
            newSighting.save();
        }
        else{
            NormalAnimal normalAnimal = new NormalAnimal(animalName,animalHealth,animalAge);
            normalAnimal.save();
            Sighting newSighting = new Sighting(normalAnimal.getName(),location,newRanger.getId());
            newSighting.save();
        }
        return new ModelAndView(model,"success.hbs");
    },new HandlebarsTemplateEngine());

    //location

    get("/sightings",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("sightings", Sighting.all());
        return new ModelAndView(model,"sighting-locations.hbs");
    },new HandlebarsTemplateEngine());

//    sightings by location

    get("/sightings/:location/details",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        String filter = request.params("location");
        model.put("location",filter);
        model.put("sightings", Sighting.getAllSightingsInLocation(filter));
        return new ModelAndView(model,"sighting-locations-details.hbs");
    },new HandlebarsTemplateEngine());

//    all rangers
    get("/rangers",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("rangers", Ranger.all());
        return new ModelAndView(model,"all-rangers.hbs");
    },new HandlebarsTemplateEngine());

//
    }

