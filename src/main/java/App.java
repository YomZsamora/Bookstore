import dao.Sql2oAuthorDao;
import models.Author;
import models.Books;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String args[]){
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
//        String connectionString = "jdbc:h2:~/bookstore_db.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", ""); // User Roles. Provide the Username and the password
        String connectionString = "jdbc:postgresql://ec2-23-21-76-49.compute-1.amazonaws.com:5432/df2ubtmuhc32s7"; //!
        Sql2o sql2o = new Sql2o(connectionString, "lncbeclmszzvdw", "12ccc71359e56acdbb39e134effcbf9db514dc790d42e1cb204ca5cd80468aa6"); //!
        Sql2oAuthorDao authorDao = new Sql2oAuthorDao(sql2o);


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Author> authors = authorDao.getAllAuthors();
//            ArrayList<Books> books = Books.getAllBooks();
            model.put("authors", authors);
//            model.put("books", books);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/postNewAuthor", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String authorName = request.queryParams("authorName"); // Get the value from the input via the POST method
            Author newAuthor = new Author(authorName); // Now we've created an instance of Author
            authorDao.addAuthor(newAuthor);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
//
//        post("/postNewBook", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            String bookName = request.queryParams("book_name");
//            int noOfPages = Integer.parseInt(request.queryParams("no_of_Pages"));
//            String description = request.queryParams("description");
//            int bookAuthor = Integer.parseInt(request.queryParams("bookAuthor"));
//            Author newAuthor = Author.findAuthor(bookAuthor);
//            Books newBook =  new Books(bookName, noOfPages, description);
//            newAuthor.addBookToAuthor(newBook);
//            response.redirect("/");
//            return null;
//        }, new HandlebarsTemplateEngine());
//
//        get("/author/:id", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            Author thisAuthor = Author.findAuthor(Integer.parseInt(request.params("id")));
//            List<Books> authorBooks = thisAuthor.getAuthorsBooks();
//            model.put("thisAuthor", thisAuthor);
//            model.put("authorBooks", authorBooks);
//            return new ModelAndView(model, "author.hbs");
//        }, new HandlebarsTemplateEngine());


    }
}
