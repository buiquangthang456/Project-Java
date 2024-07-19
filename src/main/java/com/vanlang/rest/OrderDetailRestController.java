package com.vanlang.rest;

import com.vanlang.entity.OrderDetail;
import com.vanlang.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderdetails")
public class OrderDetailRestController {

	@Autowired
	OrderDetailService orderDetailService;

	@GetMapping
	public List<OrderDetail> getAll() {
		return orderDetailService.findAll();
	}
}
