package com.chakrar.cb.prodcat;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdcatApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ProdcatApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(ProdcatApplication.class, args);
		log.info(" Running ProdcatApplication "+new Date ());
	}
}
