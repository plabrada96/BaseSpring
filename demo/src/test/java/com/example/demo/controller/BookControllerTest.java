
package com.example.demo.controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ActiveProfiles("test")
@WebAppConfiguration
@ExtendWith(MockitoExtension.class)
@EnableWebMvc
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class BookControllerTest {

	private static final String RESPONSE_UPLOAD_FILE_METHOD = "first_name";
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private BookController bookController;
	
	@Value("${mock.file.path}")
	private String mockFilePath;
	

//	@Test
//	public void uploadFileTest() throws Exception {
//		File testFile = new File(mockFilePath);
//		InputStream targetStream = new FileInputStream(testFile);
//		MockMultipartFile firstFile = new MockMultipartFile("file", testFile.getName(),
//				MediaType.MULTIPART_FORM_DATA_VALUE, targetStream);
//		
//		  ResponseEntity<String> response = new RestTemplate().exchange(request, byte[].class);
//
//	        Mockito.when(bookController.upload(Mockito.any(MultipartFile.class))).thenReturn(ResponseEntity.ok());
//
//	        mockMvc.perform(MockMvcRequestBuilders.multipart("/fileUpload")
//	                .file("file", jsonFile.getBytes())
//	                .characterEncoding("UTF-8"))
//	        .andExpect(status().isOk());
//
//	}
}
