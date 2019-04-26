package com.redlum.coursecm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.redlum.coursecm.model.Category;
import com.redlum.coursecm.model.Product;
import com.redlum.coursecm.repositories.CategoryRepository;
import com.redlum.coursecm.repositories.ProductRepository;

@SpringBootApplication
public class CoursecmApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository cr;
	
	@Autowired
	private ProductRepository pr;
	
	public static void main(String[] args) {
		SpringApplication.run(CoursecmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 700.40);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		
		cr.saveAll(Arrays.asList(cat1, cat2));
		pr.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
