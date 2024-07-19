package com.vanlang.service;

import com.vanlang.entity.Category;

import java.util.List;

public interface CategoryService {

	List<Category> findAll();

	Category findById(String id);

	Category create(Category category);

	Category update(Category category);

	void delete(String id);

}
