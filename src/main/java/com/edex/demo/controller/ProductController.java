package com.edex.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edex.demo.model.Product;
import com.edex.demo.repo.ProductRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepo productrepo;
		
	@PostMapping("/addproduct")
	public ResponseEntity<?> addproduct(@RequestBody Product product) {
		Product savedEntity = productrepo.saveAndFlush(product);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(savedEntity);
	}
	
	@GetMapping("/findbycategory/{categoryname}")
	public ResponseEntity<?> findbycategory(@PathVariable String categoryname) {
		List<Product>category = productrepo.findbycategory(categoryname);
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(category);
	}
	
//
}
