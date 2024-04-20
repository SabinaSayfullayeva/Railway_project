package com.example.railway.service.impl;

import com.example.railway.domain.User;
import com.example.railway.dto.user.UserLoginDTO;
import com.example.railway.dto.user.UserSignUpDTO;
import com.example.railway.dto.web.JwtTokenResponse;
import com.example.railway.provider.JwtTokenProvider;
import com.example.railway.repository.UserRepository;
import com.example.railway.service.AuthService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public JwtTokenResponse signUp(final UserSignUpDTO dto) {
        if (userRepository.existsByEmailAndEnabledTrue(dto.email())) {
            throw new IllegalArgumentException("Email already registered");
        }
        User user = User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .build();

        userRepository.save(user);
        return  new JwtTokenResponse(jwtTokenProvider.generateToken(user), null);
    }

    public JwtTokenResponse login(final UserLoginDTO dto) {
        final var optionalUser = userRepository.findByEmail(dto.email());
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException(dto.email());
        }

        if (!passwordEncoder.matches( dto.password(), optionalUser.get().getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }

        return new JwtTokenResponse(
                jwtTokenProvider.generateToken(optionalUser.get()),
                null
        );
    }
}
