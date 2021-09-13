package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.demo.commons.Service.GenericServiceImpl;
import com.example.demo.model.dao.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService extends GenericServiceImpl<Book, Long> {

	public BookService(BookRepository repository) {
		super(repository);
	}

	public String uploadFile(InputStream file) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook(file);
		String field = wb.getSheetAt(0).getRow(0).getCell(1).getStringCellValue();

		return field;

	}

}
