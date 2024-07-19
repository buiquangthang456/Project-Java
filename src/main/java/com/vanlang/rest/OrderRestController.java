package com.vanlang.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.vanlang.entity.Order;
import com.vanlang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {

	@Autowired
	OrderService orderService;

	@PostMapping
	public Order create(@RequestBody JsonNode orderData) {
		return orderService.create(orderData);
	}
	@GetMapping
	public List<Order> getAll() {
		return orderService.findAll();
	}
}
