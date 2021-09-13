package com.example.demo.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class BookServiceTest {

	@InjectMocks
	private BookService bookService;

	private static final String RESPONSE_UPLOAD_FILE_METHOD = "first_name";

	@Value("${mock.file.path}")
	private String mockFilePath;

	@Test
	public void uploadFile() {
		try {
			File testFile = new File(mockFilePath);
			assertNotNull(testFile);
			InputStream targetStream = new FileInputStream(testFile);
			String response = bookService.uploadFile(targetStream);
			assertEquals(RESPONSE_UPLOAD_FILE_METHOD, response);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
