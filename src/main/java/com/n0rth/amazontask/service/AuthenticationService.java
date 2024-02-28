package com.n0rth.amazontask.service;

import com.n0rth.amazontask.dto.request.LoginRequest;
import com.n0rth.amazontask.dto.request.RegistrationRequest;
import com.n0rth.amazontask.dto.response.JwtResponse;

public interface AuthenticationService {
    JwtResponse login(LoginRequest request);

    String register(RegistrationRequest request);
}
