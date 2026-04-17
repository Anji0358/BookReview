package com.example.bookreview.service;

/*
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
	        user.setRole("ROLE_USER");

	        userRepository.save(user);
	    }
}
*/