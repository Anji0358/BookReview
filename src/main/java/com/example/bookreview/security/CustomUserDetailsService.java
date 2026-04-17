package com.example.bookreview.security;

/*
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりません"));

        return new LoginUser(
                user,
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}
*/