package com.advertisement.dao;

import com.advertisement.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AuthorDaoImp implements AuthorDao{

    private SessionFactory sessionFactory;

    @Autowired
    public AuthorDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long save(Author author) {
        sessionFactory.getCurrentSession().save(author);
        return author.getId();
    }

    @Override
    public Author get(long id) {
        return sessionFactory.getCurrentSession().get(Author.class, id);
    }

    @Override
    public List<Author> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);
        cq.select(root);
        Query<Author> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(long id, Author author) {
        Session session = sessionFactory.getCurrentSession();
        Author author2 = session.byId(Author.class).load(id);
        author2.setFirstName(author.getFirstName());
        author2.setLastName(author.getLastName());
        author2.setPassword(author.getPassword());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Author author = session.byId(Author.class).load(id);
        session.delete(author);
    }
}
