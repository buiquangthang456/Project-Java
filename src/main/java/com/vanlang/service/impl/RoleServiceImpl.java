package com.vanlang.service.impl;

import com.vanlang.dao.RoleDAO;
import com.vanlang.entity.Role;
import com.vanlang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDAO dao;

	public List<Role> findAll() {
		return dao.findAll();
	}
}
