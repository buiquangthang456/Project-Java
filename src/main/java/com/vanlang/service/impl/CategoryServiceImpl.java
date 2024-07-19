package com.vanlang.service.impl;

import com.vanlang.dao.CategoryDAO;
import com.vanlang.entity.Category;
import com.vanlang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO cdao;

	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

	@Override
	public Category findById(String id) {
		return cdao.findById(id).get();
	}

	public Category create(Category category) {
		return cdao.save(category);
	}

	@Override
	public Category update(Category category) {
		return cdao.save(category);
	}

	@Override
	public void delete(String id) {
		cdao.deleteById(id);
	}

}
