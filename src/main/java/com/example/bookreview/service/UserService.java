package com.example.bookreview.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookreview.entity.User;
import com.example.bookreview.form.SignupForm;
import com.example.bookreview.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	 @Transactional
	    public void signup(SignupForm signupForm) {
	        if (userRepository.findByUsername(signupForm.getUsername()).isPresent()) {
	            throw new IllegalArgumentException("このユーザー名はすでに使われています");
	        }

	        if (userRepository.findByEmail(signupForm.getEmail()).isPresent()) {
	            throw new IllegalArgumentException("このメールアドレスはすでに使われています");
	        }

	        User user = new User();
	        user.setUsername(signupForm.getUsername());
	        user.setEmail(signupForm.getEmail());
	        user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
	        user.setRole("USER");

	        userRepository.save(user);
	    }
}