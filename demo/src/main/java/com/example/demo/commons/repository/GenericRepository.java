package com.example.demo.commons.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.demo.commons.model.GenericEntity;



@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity<T>> extends JpaRepository<T, Long> {
}