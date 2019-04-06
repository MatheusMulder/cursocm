package com.redlum.coursecm.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redlum.coursecm.model.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Category> list() {
		Category cat = new Category(1, "Web Services");
		Category cat1 = new Category(2, "Custom Services");
		
		List<Category> listCategory = new ArrayList<>();
		listCategory.add(cat);
		listCategory.add(cat1);
		return  listCategory;
	}
	

}
