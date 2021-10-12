package com.advertisement.dao;

import com.advertisement.model.Advertisement;
import com.advertisement.model.Author;

import java.util.List;

public interface AuthorDao {
    long save(Author author);

    Author get(long id);

    List<Author> list();

    void update(long id, Author author);

    void delete(long id);
}
