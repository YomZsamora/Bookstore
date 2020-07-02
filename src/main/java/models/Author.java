package models;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String authorName;
    private static ArrayList<Author> allAuthors = new ArrayList<>();
    private int id;
    private List<Books> authorsBooks;

    public Author(String authorName){
        this.authorName = authorName;
        allAuthors.add(this); // Add authors to the ArrayList
        this.id = allAuthors.size(); // Stores ID for each individual author
        this.authorsBooks = new ArrayList<Books>();
    }

    public String getAuthorName() {
        return authorName;
    }

    public static ArrayList<Author> getAllAuthors() {
        return allAuthors;
    }

    public int getId() {
        return id;
    }

    public static Author findAuthor(int id){
        return allAuthors.get(id-1);
    }


    public void addBookToAuthor(Books newBook){
        authorsBooks.add(newBook);
    }

    public List<Books> getAuthorsBooks() {
        return authorsBooks;
    }
}
