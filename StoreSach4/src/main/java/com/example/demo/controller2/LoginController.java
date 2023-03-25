package com.example.demo.controller2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity2.User;
import com.example.demo.model.UserDTO;
import com.example.demo.repository2.UserRepo;
import com.example.demo.utils.RoleEnum;

@Controller

public class LoginController {
	@Autowired
	private UserRepo userRepo;

//	@GetMapping("/login")
//	public String login(HttpServletRequest request, 
//			@RequestParam(name = "err", required = false) String error) {
//		if (error != null) {
//			request.setAttribute("err", error);
//		}
//		return "login.html";
//	}
//	
////	@GetMapping("/dang-nhap")
////	public String login() {
////		return "login.html";
////	}
//	
//	@GetMapping("/register")
//	public String showRegistrationForm(Model model) {
//	    model.addAttribute("user", new User());
//	     
//	    return "register.html";
//	}
//	
//	@PostMapping("/process_register")
//	public String processRegister(User user) {
//	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	    String encodedPassword = passwordEncoder.encode(user.getPassword());
//	    user.setEnabled(true);
//	    user.setRole(RoleEnum.ADMIN.getRoleName());
//	    user.setPassword(encodedPassword);
//	    userRepo.save(user);
//	     
//	    return "register_success.html";
//	}
	
	@GetMapping(value = "/login")
	public String login(HttpServletRequest request, 
			@RequestParam(name = "err", required = false) String error) {
		if (error != null) {
			request.setAttribute("err", error);
		}
		return "login";
	}

	@GetMapping(value = "/register")
	public String register(HttpServletRequest request) {
		return "register";
	}
	
	@PostMapping(value = "/register")
	public String register(@ModelAttribute User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    
		user.setEnabled(true);
		user.setPassword(encodedPassword);
		user.setRole(RoleEnum.MEMBER.getRoleName());
		userRepo.save(user);
		return "redirect:/login";
	}
}
