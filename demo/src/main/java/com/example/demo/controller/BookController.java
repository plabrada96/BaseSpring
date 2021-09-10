package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.commons.controller.GenericController;
import com.example.demo.commons.repository.GenericRepository;
import com.example.demo.model.dao.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController extends GenericController<Book> {

	@Autowired
	private BookService service;

	public BookController(GenericRepository<Book> repository) {
		super(repository);
	}

	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) {

	
		try {
			
			return service.importarArchivo(file.getInputStream());
		} catch (IllegalStateException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

}