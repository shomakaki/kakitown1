package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Item;
import com.example.demo.form.CartForm;
import com.example.demo.form.ItemForm;
import com.example.demo.service.ItemService;

@Controller
@RequestMapping("")
public class ItemController {
	
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item")
	public String index(Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemList",itemList);
		return "item/item_list";
		
	}
	
	@ModelAttribute
	private ItemForm itemForm() {
		return new ItemForm();
	}
	
	@ModelAttribute
	public CartForm setUpCartForm() {
		return new CartForm();
	}
	
	@RequestMapping("/search")
	public String search(Model model,ItemForm itemForm) {
		List<Item> itemList = itemService.search(itemForm.getName());
		model.addAttribute("itemList",itemList);
		return "item/item_list";
				
	}
	
	@RequestMapping("/item_detail")
	public String showDetail(Model model,Integer id) {
		Item item = itemService.load(id);
		model.addAttribute("item",item);
		return "item/item_detail";
	}
}
