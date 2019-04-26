package com.redlum.coursecm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.redlum.coursecm.model.Category;
import com.redlum.coursecm.repositories.CategoryRepository;

@SpringBootApplication
public class CoursecmApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository cr;
	
	public static void main(String[] args) {
		SpringApplication.run(CoursecmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		cr.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
