package com.advertisement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.advertisement.dao.AdvertisementDao;
import com.advertisement.model.Advertisement;

@Service
@Transactional(readOnly = true)
public class AdvertisementServiceImp implements AdvertisementService {

    private AdvertisementDao advertisementDao;
    @Autowired
    public AdvertisementServiceImp(AdvertisementDao advertisementDao) {
        this.advertisementDao = advertisementDao;
    }

    @Transactional
    @Override
    public long save(Advertisement advertisement) {
        return advertisementDao.save(advertisement);
    }

    @Override
    public Advertisement get(long id) {
        return advertisementDao.get(id);
    }

    @Override
    public List<Advertisement> list() {
        return advertisementDao.list();
    }

    @Transactional
    @Override
    public void update(long id, Advertisement advertisement) {
        advertisementDao.update(id, advertisement);
    }

    @Transactional
    @Override
    public void delete(long id) {
        advertisementDao.delete(id);
    }
}
