package com.service.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ps.entity.ProductEntity;
import com.service.ps.repository.ProductRepository;

@Service
public class ProductService {
		@Autowired
		ProductRepository repository;
		//to save in db
		public ProductEntity saveProduct(ProductEntity product)
		{
			return repository.save(product);
		}
		
		public List<ProductEntity> getAllProducts()
		{
			return repository.findAll();
		}
		
		public ProductEntity getProductById(Long id)
		{
			return repository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"+ id));
		}
		
		public void deleteProduct(Long id)
		{
			repository.deleteById(id);
		}
		
		
}
