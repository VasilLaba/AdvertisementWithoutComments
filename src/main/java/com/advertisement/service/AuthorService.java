package com.advertisement.service;

import com.advertisement.model.Author;

import java.util.List;

public interface AuthorService {
    long save(Author author);

    Author get(long id);

    List<Author> list();

    void update(long id, Author author);

    void delete(long id);
}
