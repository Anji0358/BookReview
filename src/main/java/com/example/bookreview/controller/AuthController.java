package com.example.bookreview.controller;

import jakarta.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookreview.entity.User;
import com.example.bookreview.form.SignupForm;
import com.example.bookreview.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@GetMapping("/signin")
	public String login() {
		return "signin";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(
			@Valid @ModelAttribute SignupForm signupForm,
			BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "signup";
		}

		if (userRepository.findByUsername(signupForm.getUsername()).isPresent()) {
			model.addAttribute("errorMessage", "このユーザー名はすでに使われています");
			return "signup";
		}

		if (userRepository.findByEmail(signupForm.getEmail()).isPresent()) {
			model.addAttribute("errorMessage", "このメールアドレスはすでに使われています");
			return "signup";
		}

		User user = new User();
		user.setUsername(signupForm.getUsername());
		user.setEmail(signupForm.getEmail());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		user.setRole("USER");

		userRepository.save(user);

		return "redirect:/signin";
	}
}