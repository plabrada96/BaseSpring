package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.demo.commons.Service.GenericService;
import com.example.demo.model.dao.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService extends GenericService<Book>{
	
	public BookService(BookRepository repository) {
		super(repository);
	}
	
	public String importarArchivo(InputStream archivo) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook(archivo);
		String celda= wb.getSheetAt(0).getRow(0).getCell(1).getStringCellValue();
		wb.close();
		
		return celda;
		
	}

}
