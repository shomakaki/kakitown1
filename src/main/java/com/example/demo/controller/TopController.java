package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TopController {
	@RequestMapping("/toTop")
	public String toTop() {
		return "top/top";
	}
}
