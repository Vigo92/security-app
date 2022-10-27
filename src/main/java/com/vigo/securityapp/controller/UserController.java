package com.vigo.securityapp.controller;

import com.vigo.securityapp.model.dto.AppUserDTO;
import com.vigo.securityapp.model.request.LoginRequest;
import com.vigo.securityapp.model.response.LoginResponse;
import com.vigo.securityapp.model.response.SignupResponse;
import com.vigo.securityapp.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 27/10/2022
 **/

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final AppUserService appUserService;

    @PostMapping("register")
    public ResponseEntity<SignupResponse> register(@Valid @RequestBody AppUserDTO signupRequest) {
        SignupResponse signupResponse = appUserService.createUser(signupRequest);
        return new ResponseEntity<>(signupResponse, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = appUserService.login(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @PutMapping("confirm")
    public ResponseEntity<SignupResponse> login(@RequestParam("token") String token) {
        SignupResponse signupResponse = appUserService.confirmToken(token);
        return new ResponseEntity<>(signupResponse, HttpStatus.OK);
    }
}
