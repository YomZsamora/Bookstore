package models;

import java.util.ArrayList;

public class Books {

    private String bookName;
    private int noOfPages;
    private String description;
    private static ArrayList<Books> allBooks = new ArrayList<>();
    private int id;

    public Books(String bookName, int noOfPages, String description){
        this.bookName = bookName;
        this.noOfPages = noOfPages;
        this.description = description;
        allBooks.add(this);
        this.id = allBooks.size();

    }

    public String getBookName() {
        return bookName;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<Books> getAllBooks() {
        return allBooks;
    }

    public int getId() {
        return id;
    }
}
