package com.example.bookreview.controller;

/*
@Controller
@RequiredArgsConstructor
public class AuthController {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String login() {
		return "login";
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

		return "redirect:/login";
	}
}
*/
