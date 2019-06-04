package com.redlum.coursecm.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.redlum.coursecm.dto.CategoryDTO;
import com.redlum.coursecm.model.Category;
import com.redlum.coursecm.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService cs;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Category obj = cs.find(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoryDTO objDTO) {
		Category obj  = cs.fromDTO(objDTO);
		obj = cs.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Category obj) {
		obj.setId(id);
		obj = cs.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		cs.delete(id);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<Category> listObj = cs.findAll();
		List<CategoryDTO> listObjDTO = listObj.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listObjDTO);

	}

	/* /categories/page?page=0&linesPage=20&orderBy=&direction */

	@RequestMapping(value = "page", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoryDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Category> listObj = cs.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoryDTO> listObjDTO = listObj.map(obj -> new CategoryDTO(obj));
		return ResponseEntity.ok().body(listObjDTO);

	}

}
