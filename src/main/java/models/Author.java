package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author {

    private String authorName;
    private int id;

    public Author(String authorName){
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                authorName.equals(author.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName, id);
    }
}
