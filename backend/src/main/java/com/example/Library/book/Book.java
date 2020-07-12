package com.example.Library.book;

import com.example.Library.author.Author;
import com.example.Library.configurations.auditFields.AuditFields;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
@EntityListeners(AuditingEntityListener.class)
public class Book extends AuditFields {

    @Id
    @GeneratedValue
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    public Book() {}

    public int getId() { return id; }

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

}
