package com.example.bookreview.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookreview.form.SignupForm;
import com.example.bookreview.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/signup")
	public String showSignuprForm(Model model) {
		
		model.addAttribute("signupForm", new SignupForm());
		return "auth/signup";
	}

	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute SignupForm signupForm,
			BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "auth/signup";
		}

		try {
			
			userService.signup(signupForm);
			return "redirect:/login";
	
		} catch (IllegalArgumentException e) {
		
			model.addAttribute("errorMessage", e.getMessage());
			return "auth/signup";
	
		}
	}

	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}
}
