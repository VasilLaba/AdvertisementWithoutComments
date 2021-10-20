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

import com.advertisement.model.Author;
import com.advertisement.service.AuthorService;

@CrossOrigin(origins = "*")
@RestController
public class AuthorController {

    private AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /*---Add new author---*/
    @PostMapping("/author")
    public ResponseEntity<?> save(@RequestBody Author author) {
        System.out.println("the json value of author is :::::: "+author);
        long id = authorService.save(author);
        return ResponseEntity.ok().body("New Author has been saved with ID:" + id);
    }

    /*---Get a author by id---*/
    @GetMapping("/author/get/{id}")
    public ResponseEntity<Author> get(@PathVariable("id") int id) {
        Author author = authorService.get(id);
        return ResponseEntity.ok().body(author);
    }

    /*---get all authors---*/
    @GetMapping("/author/getall")
    public ResponseEntity<List<Author>> list() {
        List<Author> authors = authorService.list();
        return ResponseEntity.ok().body(authors);
    }

    /*---Update a author by id---*/
    @PutMapping("/author/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Author author) {
        authorService.update(id, author);
        return ResponseEntity.ok().body("Author has been updated successfully.");
    }

    /*---Delete a author by id---*/
    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        authorService.delete(id);
        return ResponseEntity.ok().body("Author has been deleted successfully.");
    }
}
