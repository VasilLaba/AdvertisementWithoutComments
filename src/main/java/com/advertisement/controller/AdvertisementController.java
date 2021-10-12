package com.advertisement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advertisement.model.Advertisement;
import com.advertisement.service.AdvertisementService;

@CrossOrigin(origins = "*")
@RestController
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    /*---Add new advertisement---*/
    @PostMapping("/advertisement")
    public ResponseEntity<?> save(@RequestBody Advertisement advertisement) {
        System.out.println("the json value of advertisement is :::::: "+advertisement);
        long id = advertisementService.save(advertisement);
        return ResponseEntity.ok().body("New Advertisement has been saved with ID:" + id);
    }

    /*---Get a advertisement by id---*/
    @GetMapping("/advertisement/{id}")
    public ResponseEntity<Advertisement> get(@PathVariable("id") long id) {
        Advertisement advertisement = advertisementService.get(id);
        return ResponseEntity.ok().body(advertisement);
    }

    /*---get all advertisements---*/
    @GetMapping("/advertisement")
    public ResponseEntity<List<Advertisement>> list() {
        List<Advertisement> advertisements = advertisementService.list();
        return ResponseEntity.ok().body(advertisements);
    }

    /*---Update a advertisement by id---*/
    @PutMapping("/advertisement/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Advertisement advertisement) {
        advertisementService.update(id, advertisement);
        return ResponseEntity.ok().body("Advertisement has been updated successfully.");
    }

    /*---Delete a advertisement by id---*/
    @DeleteMapping("/advertisement/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        advertisementService.delete(id);
        return ResponseEntity.ok().body("Advertisement has been deleted successfully.");
    }
}
