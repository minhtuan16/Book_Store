//package com.example.demo.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class AdminController {
//
//	@GetMapping("/login")
//	public String login() {
//		return "/admin/login.html";
//	}
//
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//
//		session.invalidate();
//
//		return "redirect:/admin/login";
//	}
//}
