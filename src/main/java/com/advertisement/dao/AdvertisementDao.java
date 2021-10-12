package com.advertisement.dao;

import java.util.List;

import com.advertisement.model.Advertisement;

public interface AdvertisementDao {
    long save(Advertisement advertisement);

    Advertisement get(long id);

    List<Advertisement> list();

    void update(long id, Advertisement advertisement);

    void delete(long id);
}
