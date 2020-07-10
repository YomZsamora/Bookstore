package models;

import java.util.ArrayList;
import java.util.Objects;

public class Books {

    private String bookName;
    private int noOfPages;
    private String description;
    private int id;

    public Books(String bookName, int noOfPages, String description){
        this.bookName = bookName;
        this.noOfPages = noOfPages;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return noOfPages == books.noOfPages &&
                id == books.id &&
                bookName.equals(books.bookName) &&
                description.equals(books.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, noOfPages, description, id);
    }
}
