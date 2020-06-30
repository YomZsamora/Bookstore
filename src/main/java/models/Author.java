package models;

import java.util.ArrayList;

public class Author {

    private String authorName;
    private static ArrayList<Author> allAuthors = new ArrayList<>();
    private int id;

    public Author(String authorName){
        this.authorName = authorName;
        allAuthors.add(this);
        this.id = allAuthors.size();
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
}
