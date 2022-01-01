package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Order;
import com.example.demo.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public void orderInsert(Order order) {
		orderRepository.orderInsert(order);
	}

	
		
}
