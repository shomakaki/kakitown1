package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Cart;
import com.example.demo.domain.Item;
import com.example.demo.domain.Order;
import com.example.demo.form.CartForm;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;

@Controller
@RequestMapping("")
public class CartController {
	
	
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/cart")
	public String cart(CartForm cartForm) {
		Cart cart = new Cart();
		cart.setItemId(Integer.parseInt(cartForm.getItemId()));
		cart.setQuantity(Integer.parseInt(cartForm.getQuantity()));
		cart.setItem(cartService.load(cart.getItemId()));
		cart.setTotalPrice(cart.getQuantity() * cart.getItem().getPriceM());
		
		List<Cart> cartItemList = new LinkedList<>();
		if(session.getAttribute("cartItemList")==null) {
		cartItemList.add(cart);
		session.setAttribute("cartItemList", cartItemList);
		}
		else {
		cartItemList = (List<Cart>) session.getAttribute("cartItemList");
		cartItemList.add(cart);
		session.setAttribute("cartItemList", cartItemList);
		}
		
		//return "cart/cart";
		return "redirect:/show";
	}
	
	@RequestMapping("/delete")
	public String delete(String index) {
		
		List<Cart> cartItemList = (List<Cart>) session.getAttribute("cartItemList");
		System.out.println(cartItemList);
		cartItemList.remove(Integer.parseInt(index));
		System.out.println(cartItemList);
		
		session.setAttribute("cartItemList", cartItemList);
		
		return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String show() {
		
		Integer sum=0;
		for(Cart cartList:(List<Cart>) session.getAttribute("cartItemList")) {
			 sum +=cartList.getTotalPrice();
		}
		
		session.setAttribute("sum", sum);
		
		return "cart/cart";
	}
		
	
	
	
}
