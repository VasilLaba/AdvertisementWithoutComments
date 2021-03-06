package com.advertisement.dao;

import com.advertisement.model.Category;
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
public class CategoryDaoImp implements CategoryDao{

    private SessionFactory sessionFactory;
    @Autowired
    public CategoryDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long save(Category category) {
        sessionFactory.getCurrentSession().save(category);
        return category.getId();
    }

    @Override
    public Category get(long id) {
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    public List<Category> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);
        Root<Category> root = cq.from(Category.class);
        cq.select(root);
        Query<Category> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(long id, Category category) {
        Session session = sessionFactory.getCurrentSession();
        Category category2 = session.byId(Category.class).load(id);
        category2.setName(category.getName());
        category2.setDescription(category.getDescription());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.byId(Category.class).load(id);
        session.delete(category);
    }
}
