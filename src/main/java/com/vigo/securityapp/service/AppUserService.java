package com.vigo.securityapp.service;

import com.vigo.securityapp.model.dto.AppUserDTO;
import com.vigo.securityapp.model.request.LoginRequest;
import com.vigo.securityapp.model.response.LoginResponse;
import com.vigo.securityapp.model.response.SignupResponse;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/
public interface AppUserService {

    SignupResponse createUser(AppUserDTO signupRequest);

    SignupResponse confirmToken(String token);

    LoginResponse login(LoginRequest loginRequest);
}
