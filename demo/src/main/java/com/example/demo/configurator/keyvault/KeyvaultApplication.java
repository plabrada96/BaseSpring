package com.example.demo.configurator.keyvault;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class KeyvaultApplication {
	
	// Azure enviroment variables
	
    @Value("${H2.USER}")
    private String userFromH2;
    
    @Value("${H2.PASSWORD}")
    private String passwordFromH2;
}
