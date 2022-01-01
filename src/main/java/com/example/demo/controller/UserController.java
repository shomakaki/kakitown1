package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;
import com.example.demo.form.LoginForm;
import com.example.demo.form.OrderForm;
import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public UserForm setupUserForm() {
		return new UserForm();
	}
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "/user/login";
	}
	
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "user/user_regist";
	}
	
	@RequestMapping("/register")
	public String toRegistr(@Validated UserForm userForm,BindingResult result) {
		if(result.hasErrors()) {
			return toRegister();
		}
		User user =new User();
		BeanUtils.copyProperties(userForm, user);
//		user.setName(userForm.getName());
		userService.insert(user);
		return "user/user_finished";
	}
	
	@ModelAttribute
	public LoginForm setupLoginForm() {
		return new LoginForm();
	}
	@ModelAttribute
	private OrderForm setUpOrderForm() {
		return new OrderForm();
	}
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/login")
	public String login(LoginForm loginForm,String email,Model model) {
		User user =new User();
		try {
			user = userService.login(loginForm.getEmail());
		} catch (Exception e) {
			model.addAttribute("emailError","メールアドレスが不正です");
			return toLogin();
		}
//		userService.login(loginForm.getEmail());
//		if(user == null) {
//			model.addAttribute("emailError","�o�^����Ă��郁�[���A�h���X�͂���܂���");
//		return toLogin();	
//		}
		if(!(loginForm.getPassword().equals(user.getPassword()))) {
			model.addAttribute("passwordError", "パスワードが不正です");
			return toLogin();
		}
		if(session.getAttribute("cartItemList") != null && user != null) {
			session.setAttribute("user", user);
			return  "redirect:/toOrder";
		}
		session.setAttribute("user", user);
		return "redirect:/item";
		
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/item";
		
	}
}
