package com.n0rth.amazontask.service.impl;

import com.n0rth.amazontask.dto.request.LoginRequest;
import com.n0rth.amazontask.dto.request.RegistrationRequest;
import com.n0rth.amazontask.dto.response.JwtResponse;
import com.n0rth.amazontask.model.User;
import com.n0rth.amazontask.repository.UserRepository;
import com.n0rth.amazontask.service.AuthenticationService;
import com.n0rth.amazontask.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String register(RegistrationRequest request) {
        User user = User.builder()
                .username(request.getUsername()).password(passwordEncoder.encode(request.getPassword()))
                .build();
//        log.info("USERS: " + userRepository.findAll().toString());
        userRepository.save(user);

//        log.info("USERS: " + userRepository.findAll().toString());

        return "Successfully registered under the nickname " + request.getUsername();
    }

    @Override
    public JwtResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        String jwt = jwtService.generateToken(user);
        return JwtResponse.builder().token(jwt).build();
    }
}
