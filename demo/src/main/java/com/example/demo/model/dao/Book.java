package com.example.demo.model.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;

import com.example.demo.commons.model.GenericEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data @EqualsAndHashCode(callSuper=false)
public class Book extends GenericEntity {
	
	private static final long serialVersionUID = -7690130212947729204L;

    private String title;

    private String author;

    @Lob
    private String description;

    private Date releaseDate;

}