package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Order;
import com.example.demo.domain.User;
import com.example.demo.form.OrderForm;
import com.example.demo.form.UserForm;
import com.example.demo.service.OrderService;

@Controller
@RequestMapping("")
public class OrderController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserController userController;
	
	
	
		@RequestMapping("/toOrder")
		public String toOrder() {
			
			User user =  (User) session.getAttribute("user");
			if(user == null) {
				return "redirect:/toLogin";
			}else {
//				if(session.getAttribute("cartItemList")==null) {
//					
//				}
				return "order/order_confirm";
			}
		
		}
		
		@RequestMapping("/order")
		public String order() {
			return "order/order_confirm";
		}
		
		@ModelAttribute
		private OrderForm setUpOrderForm() {
			return new OrderForm();
		}
		
		@Autowired
		private OrderService orderService;
		
		
		@RequestMapping("/toOrderFinish")
		public String toOrderFinished() {
			return "order/order_finished";
		}
		
		@RequestMapping("/orderFinish")
		public String orderFinish(@Validated OrderForm orderForm,BindingResult result,Order order){
			System.out.println(0);
			if(result.hasErrors()) {
				return order();
			}
			System.out.println(1);
			BeanUtils.copyProperties(orderForm, order);
			System.out.println(2);
			User user =  (User) session.getAttribute("user");
			System.out.println(3);
			order.setUserId(user.getId());
			System.out.println(4);
			order.setTotalPrice((Integer)session.getAttribute("sum"));
			System.out.println(5);
			orderService.orderInsert(order);
			System.out.println(6);
			
		return "redirect:/toOrderFinish";
			
		}
		
	

}
