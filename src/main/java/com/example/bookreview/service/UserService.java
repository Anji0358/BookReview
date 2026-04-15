package com.example.bookreview.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bookreview.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	 @Transactional
	    public void register(String username, String email, String password) {
	        if (userRepository.findByUsername(username).isPresent()) {
	            throw new IllegalArgumentException("このユーザー名はすでに使われています");
	        }

	        if (userRepository.findByEmail(email).isPresent()) {
	            throw new IllegalArgumentException("このメールアドレスはすでに使われています");
	        }

	        User user = new User();
	        user.setUsername(username);
	        user.setEmail(email);
	        user.setPassword(passwordEncoder.encode(password));
	        user.setRole("ROLE_USER");

	        userRepository.save(user);
	    }
}
