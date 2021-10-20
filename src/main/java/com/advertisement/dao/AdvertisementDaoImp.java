package com.advertisement.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advertisement.model.Advertisement;

@Repository
public class AdvertisementDaoImp implements AdvertisementDao{

    private SessionFactory sessionFactory;

    @Autowired
    public AdvertisementDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long save(Advertisement advertisement) {
        sessionFactory.getCurrentSession().save(advertisement);
        return advertisement.getId();
    }

    @Override
    public Advertisement get(long id) {
        return sessionFactory.getCurrentSession().get(Advertisement.class, id);
    }

    @Override
    public List<Advertisement> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Advertisement> cq = cb.createQuery(Advertisement.class);
        Root<Advertisement> root = cq.from(Advertisement.class);
        cq.select(root);
        Query<Advertisement> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(long id, Advertisement advertisement) {
        Session session = sessionFactory.getCurrentSession();
        Advertisement advertisement2 = session.byId(Advertisement.class).load(id);
        advertisement2.setTitle(advertisement.getTitle());
//        advertisement2.setAuthor(advertisement.getAuthor());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Advertisement advertisement = session.byId(Advertisement.class).load(id);
        session.delete(advertisement);
    }
}
