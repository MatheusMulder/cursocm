package com.redlum.coursecm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.redlum.coursecm.model.Address;
import com.redlum.coursecm.model.Category;
import com.redlum.coursecm.model.City;
import com.redlum.coursecm.model.Customer;
import com.redlum.coursecm.model.Product;
import com.redlum.coursecm.model.State;
import com.redlum.coursecm.model.enums.CustomerType;
import com.redlum.coursecm.repositories.AddressRepository;
import com.redlum.coursecm.repositories.CategoryRepository;
import com.redlum.coursecm.repositories.CityRepository;
import com.redlum.coursecm.repositories.CustomerRepository;
import com.redlum.coursecm.repositories.ProductRepository;
import com.redlum.coursecm.repositories.StateRepository;

@SpringBootApplication
public class CoursecmApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository cr;

	@Autowired
	private ProductRepository pr;

	@Autowired
	private StateRepository sr;

	@Autowired
	private CityRepository cityr;

	@Autowired
	private CustomerRepository custr;

	@Autowired
	private AddressRepository addrr;

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

		State e1 = new State(null, "Minas Gerais");
		State e2 = new State(null, "São Paulo");

		City c1 = new City(null, "Uberlândia", e1);
		City c2 = new City(null, "São Paulo", e2);
		City c3 = new City(null, "Campinas", e2);

		e1.getCities().addAll(Arrays.asList(c1));
		e2.getCities().addAll(Arrays.asList(c2, c3));

		sr.saveAll(Arrays.asList(e1, e2));
		cityr.saveAll(Arrays.asList(c1, c2, c3));

		Customer cust1 = new Customer(null, "Maria Silva", "maria@gmail.com", "10139480900", CustomerType.PF);
		cust1.getPhoneNumbers().addAll(Arrays.asList("2333444", "1344422"));

		Address ad1 = new Address(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cust1, c1);
		Address ad2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "3877012", cust1, c2);

		custr.saveAll(Arrays.asList(cust1));
		addrr.saveAll(Arrays.asList(ad1, ad2));

	}

}
