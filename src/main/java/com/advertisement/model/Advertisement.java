package com.advertisement.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "advertisement")
public class Advertisement {
    private int id;
    private String title;
    private String description;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id")
    private Category category;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id")
    private Author author;
    private LocalDateTime createDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

}
