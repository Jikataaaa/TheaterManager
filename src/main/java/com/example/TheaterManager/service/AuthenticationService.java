package com.example.TheaterManager.service;

import com.example.TheaterManager.models.auth.AuthenticationResponse;
import com.example.TheaterManager.models.auth.LoginRequest;
import com.example.TheaterManager.models.auth.RegisterRequest;
import com.example.TheaterManager.models.entities.User;
import com.example.TheaterManager.models.enums.UserRole;
import com.example.TheaterManager.models.view.UserView;

import java.util.List;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);

    UserRole getUserRole(String username);

    User getUserByUsername(String username);

    List<UserView> getAllUsers();

}
