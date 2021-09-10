package com.example.demo.commons.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.commons.model.GenericEntity;
import com.example.demo.commons.repository.GenericRepository;

public abstract class GenericService<T extends GenericEntity<T>> {

    private final GenericRepository<T> repository;

    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public Page<T> getPage(Pageable pageable){
        return repository.findAll(pageable);
    }

    public T get(Long id){
        return repository.findById(id).orElseThrow(
        );
    }

    @Transactional
    public T update(T updated){
        T dbDomain = get(updated.getId());
        dbDomain.update(updated);

        return repository.save(dbDomain);
    }

    @Transactional
    public T create(T newDomain){
        T dbDomain = newDomain.createNewInstance();
        return repository.save(dbDomain);
    }

    @Transactional
    public void delete(Long id){
        get(id);
        repository.deleteById(id);
    }
}