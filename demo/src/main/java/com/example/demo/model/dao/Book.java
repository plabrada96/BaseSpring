package com.example.demo.model.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.example.demo.commons.model.GenericEntity;

import lombok.Data;

@Data
@Entity
public class Book implements Serializable, GenericEntity<Book> {

	private static final long serialVersionUID = -7690130212947729204L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;

    @Lob
    private String description;

    private Date releaseDate;

    @Override
    public Long getId(){
        return this.id;
    }

    @Override
    public void update(Book source) {
        this.title = source.getTitle();
        this.author =source.getAuthor();
        this.description = source.getDescription();
        this.releaseDate = source.getReleaseDate();
    }

    @Override
    public Book createNewInstance() {
        Book newInstance = new Book();
        newInstance.update(this);

        return newInstance;
    }
}