package com.vanlang.dao;

import com.vanlang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(String cid);

//	@Query(value = "SELECT count(p.id) FROM Products p", nativeQuery = true)
//	Integer countAllProduct();
}
