package com.advertisement.service;

import com.advertisement.model.Advertisement;

import java.util.List;

public interface AdvertisementService {
    long save(Advertisement advertisement);

    Advertisement get(long id);

    List<Advertisement> list();

    void update(long id, Advertisement advertisement);

    void delete(long id);
}
