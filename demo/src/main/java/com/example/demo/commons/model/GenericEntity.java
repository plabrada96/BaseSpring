package com.example.demo.commons.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.Version;
import javax.persistence.Id;
import lombok.Data;

@MappedSuperclass
@Data
public class GenericEntity implements Serializable{

	private static final long serialVersionUID = 6571913292391065789L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Version
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public GenericEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }   
}