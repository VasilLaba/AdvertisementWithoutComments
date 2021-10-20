package com.advertisement.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
//import java.validation.constreins.Pattern;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 //   @Column(name = "first_name", nullable = false)
 //   @Pattern(regexp = "[A-Z][a-z]", message = "M")
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    private String password;
    @Column(name = "created_date")
    private LocalDateTime createDate;
    @OneToMany(mappedBy = "author")
    private List<Advertisement> advertisements;


    public Author() {
    }

    public Author(String firstName, String lastName, String password, LocalDateTime createDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public Author setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Author setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public Author setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Author setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public Author setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) &&
                Objects.equals(password, author.password) && Objects.equals(createDate, author.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, password, createDate);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Author{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append('}');
        return sb.toString();
    }
}
