package com.edex.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edex.demo.model.Product;
import com.edex.demo.model.Register;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	@Query(value = "SELECT * FROM PRODUCT WHERE category = :category",nativeQuery = true)
	List<Product>findbycategory(String category);
}
