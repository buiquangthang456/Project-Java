package com.vanlang.service.impl;

import com.vanlang.dao.OrderDetailDAO;
import com.vanlang.entity.OrderDetail;
import com.vanlang.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailDAO dao;

	@Override
	public List<OrderDetail> findAll() {
		return dao.findAll();
	}


}
