import models.Author;
import models.Books;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            ArrayList<Books> books = Books.getAllBooks();
            model.put("authors", authors);
            model.put("books", books);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/postNewAuthor", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String authorName = request.queryParams("authorName"); // Get the value from the input via the POST method
            Author newAuthor = new Author(authorName); // Now we've created an instance of Author
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        post("/postNewBook", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String bookName = request.queryParams("bookName");
            int noOfPages = Integer.parseInt(request.queryParams("noOfPages"));
            String description = request.queryParams("description");
            int bookAuthor = Integer.parseInt(request.queryParams("bookAuthor"));
            Author newAuthor = Author.findAuthor(bookAuthor);
            Books newBook =  new Books(bookName, noOfPages, description);
            newAuthor.addBookToAuthor(newBook);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/author/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Author thisAuthor = Author.findAuthor(Integer.parseInt(request.params("id")));
            List<Books> authorBooks = thisAuthor.getAuthorsBooks();
            model.put("thisAuthor", thisAuthor);
            model.put("authorBooks", authorBooks);
            return new ModelAndView(model, "author.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
