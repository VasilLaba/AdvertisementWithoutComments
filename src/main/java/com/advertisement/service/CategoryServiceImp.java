package com.advertisement.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.advertisement.dao.CategoryDao;
import com.advertisement.model.Category;

@Service
@Transactional(readOnly = true)
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    @Override
    public long save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category get(long id) {
        return categoryDao.get(id);
    }

    @Override
    public List<Category> list() {
        return categoryDao.list();
    }

    @Transactional
    @Override
    public void update(long id, Category category) {
        categoryDao.update(id, category);
    }

    @Transactional
    @Override
    public void delete(long id) {
        categoryDao.delete(id);
    }
}
