package com.advertisement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.advertisement.dao.AuthorDao;
import com.advertisement.model.Author;

@Service
@Transactional(readOnly = true)
public class AuthorServiceImp implements AuthorService {
    @Autowired
    private AuthorDao authorDao;

    @Transactional
    @Override
    public long save(Author author) {
        return authorDao.save(author);
    }

    @Override
    public Author get(long id) {
        return authorDao.get(id);
    }

    @Override
    public List<Author> list() {
        return authorDao.list();
    }

    @Transactional
    @Override
    public void update(long id, Author author) {
        authorDao.update(id, author);
    }

    @Transactional
    @Override
    public void delete(long id) {
        authorDao.delete(id);
    }
}
