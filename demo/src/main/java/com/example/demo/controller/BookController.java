package com.example.demo.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.dao.Book;
import com.example.demo.service.BookService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/book")
public class BookController{


	@Autowired
	private BookService service;
	
	@Operation(summary = "Save a book", description = "Save a book in the database")
	@PostMapping("")
	public ResponseEntity<Book> create(@RequestBody Book book) {
		return new ResponseEntity<Book>(service.save(book), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Find all books", description = "Return all books from the database")
	@ResponseBody
	@GetMapping("")
	public ResponseEntity<Page<Book>> findAll(Pageable pageable) {
		 Pageable pageablebuilt = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
		return ResponseEntity.ok(service.findAll(pageablebuilt));
	}

	@Operation(summary = "Get one book", description = "Get a book by his id from the database")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Book>> getOne(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@Operation(summary = "Update a book", description = "Update a book by his id in the database")
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateEntityById(@RequestBody Book entity, @PathVariable Long id) {
		System.out.println("********* el ID********** "+id);
		return ResponseEntity.ok(service.updateById(entity, id));
	}

	@Operation(summary = "Delete a book", description = "Delete a book by his id from the database")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEntityById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.ok("Ok");
	}
	

	@Operation(summary = "Upload one file", description = "Test about the upload one file for the test Apache POI library")
	@RequestMapping(value = "/upload", consumes = { "multipart/form-data" }, method = RequestMethod.POST)
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {

		try {
			return ResponseEntity.ok(service.uploadFile(file.getInputStream()));
		} catch (IllegalStateException | IOException e1) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

}