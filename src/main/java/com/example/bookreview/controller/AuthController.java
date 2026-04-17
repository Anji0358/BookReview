package com.example.bookreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bookreview.form.SignupForm;

@Controller
public class AuthController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "signup";
    }
}
