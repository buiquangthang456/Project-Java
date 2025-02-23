package com.vanlang.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.vanlang.entity.Order;

import java.util.List;

public interface OrderService {
	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);

	List<Order> findAll();

	
}
