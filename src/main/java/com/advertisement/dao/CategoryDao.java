package com.advertisement.dao;

import com.advertisement.model.Category;

import java.util.List;

public interface CategoryDao {
    long save(Category category);

    Category get(long id);

    List<Category> list();

    void update(long id, Category category);

    void delete(long id);
}
