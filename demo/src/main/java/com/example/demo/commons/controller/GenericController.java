package com.example.demo.commons.controller;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.commons.Service.GenericServiceImpl;
import com.example.demo.commons.Service.IGenericService;
import com.example.demo.commons.model.GenericEntity;

public abstract class GenericController<T extends GenericEntity, ID extends Serializable>
		implements IGenericService<T, ID> {

	private GenericServiceImpl<T, ID> genericServiceImpl;
	
	@PostMapping("")
	public ResponseEntity<T> create(@RequestBody T created) {
		return ResponseEntity.ok(genericServiceImpl.save(created));
	}
	
//	@GetMapping("")
//	public ResponseEntity<Page<T>> findAll(Pageable pageable) {
//		return ResponseEntity.ok(genericServiceImpl.findAll(pageable));
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<T>> getOne(@PathVariable ID id) {
		return ResponseEntity.ok(genericServiceImpl.findById(id));
	}
	
	@PutMapping("")
	public ResponseEntity<T> updateEntityById(@RequestBody T entity, @PathVariable ID id) {
		return ResponseEntity.ok(genericServiceImpl.updateById(entity, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEntityById(@PathVariable ID id) {
		genericServiceImpl.deleteById(id);
		return ResponseEntity.ok("Ok");
	}
}
