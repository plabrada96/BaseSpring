package com.example.demo.commons.Service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.commons.model.GenericEntity;

public interface IGenericService<T extends GenericEntity, ID extends Serializable> {
	
	public abstract T save(T entity);

	public abstract Page<T> findAll(Pageable pageable); 

	public abstract Optional<T> findById(ID entityId);

	public abstract T updateById(T entity, ID entityId);

	public abstract void deleteById(ID entityId);

}
