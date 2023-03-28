package com.example.TheaterManager.service.impl;

import com.example.TheaterManager.models.auth.AuthenticationResponse;
import com.example.TheaterManager.models.auth.LoginRequest;
import com.example.TheaterManager.models.auth.RegisterRequest;
import com.example.TheaterManager.models.entities.User;
import com.example.TheaterManager.models.enums.UserRole;
import com.example.TheaterManager.models.view.UserView;
import com.example.TheaterManager.repository.UserRepository;
import com.example.TheaterManager.service.AuthenticationService;
import com.example.TheaterManager.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(@Valid RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.USER)
                .build();

        userRepository.save(user);
        String token = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(token)
                .username(user.getUsername())
                .role(user.getRole().name())
                .build();
    }

    @Override
    public AuthenticationResponse login(@Valid LoginRequest request) {
        authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findUserByUsername(request.getUsername()).orElseThrow();

        String token = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(token)
                .username(user.getUsername())
                .role(user.getRole().name())
                .build();
    }

    @Override
    public UserRole getUserRole(String username) {
        User user = userRepository.findUserByUsername(username).orElseThrow();
        return user.getRole();
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> userByUsername = userRepository.findUserByUsername(username);
        return userByUsername.orElse(null);
    }

    @Override
    public List<UserView> getAllUsers() {
        return userRepository.findAll().stream().map(user -> UserView
                        .builder()
                        .id(user.getId())
                        .name(user.getUsername())
                        .build())
                .toList();
    }
}
