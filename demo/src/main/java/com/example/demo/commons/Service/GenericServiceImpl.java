package com.example.demo.commons.Service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.commons.model.GenericEntity;
import com.example.demo.commons.repository.IGenericRepository;

@Service
@Transactional
public abstract class GenericServiceImpl<T extends GenericEntity, ID extends Serializable>
		implements IGenericService<T, ID> {

	private IGenericRepository<T, ID> abstractBaseRepository;

	@Autowired
	public GenericServiceImpl(IGenericRepository<T, ID> abstractBaseRepository) {
		this.abstractBaseRepository = abstractBaseRepository;
	}

	@Override
	public T save(T entity) {
		return (T) abstractBaseRepository.save(entity);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return abstractBaseRepository.findAll(pageable);
	}

	@Override
	public Optional<T> findById(ID entityId) {
		return abstractBaseRepository.findById(entityId);
	}

	@Override
	public T updateById(T entity, ID entityId) {
		Optional<T> optional = abstractBaseRepository.findById(entityId);
		if (optional.isPresent()) {
			return (T) abstractBaseRepository.save(entity);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(ID entityId) {
		abstractBaseRepository.deleteById(entityId);
	}

}
