import models.Author;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;
import static spark.Spark.post;

public class App {

    public static void main(String args[]){
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Author> authors = Author.getAllAuthors();
            model.put("authors", authors);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/postNewAuthor", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String authorName = request.queryParams("authorName"); // Get the value from the input via the POST method
            Author newAuthor = new Author(authorName); // Now we've created an instance of Author
            ArrayList<Author> authors = Author.getAllAuthors();
            model.put("authors", authors);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
