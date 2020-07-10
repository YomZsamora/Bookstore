package dao;

import models.Author;

import java.util.List;

public interface AuthorDao {

    void addAuthor(Author author);

    List<Author> getAllAuthors();
}
