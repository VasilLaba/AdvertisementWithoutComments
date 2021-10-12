package com.advertisement.service;

import com.advertisement.model.Category;

import java.util.List;

public interface CategoryService {
    long save(Category category);

    Category get(long id);

    List<Category> list();

    void update(long id, Category category);

    void delete(long id);
}
