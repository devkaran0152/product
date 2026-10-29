package com.service.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ps.entity.ProductEntity;
import com.service.ps.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@Valid
public class ProductController {
	@Autowired
	ProductService service;

	@PostMapping("/save")
	public ProductEntity saveData(@Valid @RequestBody ProductEntity entity)
	{
		return service.saveProduct(entity);
	}
	
	@GetMapping("/getdata")
	public List<ProductEntity> getAllData()
	{
		return service.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ProductEntity getData(@PathVariable Long id)
	{
		return service.getProductById(id);
	}
	@DeleteMapping("/{id}")
	public String deleteData(@PathVariable Long id)
	{
		service.deleteProduct(id);
		return "Data Deleted Successfully";
	}
	@PutMapping("/{id}")
	public ProductEntity updateProduct(
	        @PathVariable Long id,
	        @RequestBody ProductEntity entity) {

	    entity.setId(id);
	    return service.saveProduct(entity);
	}
}
