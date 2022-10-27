package com.vigo.securityapp.service.impl;

import com.vigo.securityapp.model.dto.AppUserDTO;
import com.vigo.securityapp.model.entity.AppUser;
import com.vigo.securityapp.model.entity.ConfirmationToken;
import com.vigo.securityapp.model.request.LoginRequest;
import com.vigo.securityapp.model.response.LoginResponse;
import com.vigo.securityapp.model.response.ResponseCode;
import com.vigo.securityapp.model.response.SignupResponse;
import com.vigo.securityapp.repository.AppUserRepository;
import com.vigo.securityapp.service.AppUserService;
import com.vigo.securityapp.service.BaseService;
import com.vigo.securityapp.service.ConfirmationTokenService;
import com.vigo.securityapp.service.EmailService;
import com.vigo.securityapp.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceImpl implements UserDetailsService, AppUserService, ResponseCode, BaseService<AppUser, AppUserDTO> {

    private final AppUserRepository appUserRepository;

    private final ConfirmationTokenService confirmationTokenService;

    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;

    private final EmailService awsEmailServiceImpl;

    @Value("confirm.email.link: http://localhost:8080/api/v1/auth/confirm?token=")
    private final String baseUrl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(username).orElseThrow(RuntimeException::new);
    }

    @Override
    public SignupResponse createUser(AppUserDTO appUserDTO) {
        validateUsersEmail(appUserDTO.getEmail());
        appUserDTO.setPassword(passwordEncoder.encode(appUserDTO.getPassword()));
        AppUser appUser = appUserRepository.save(convertDataToEntity(appUserDTO));
        ConfirmationToken confirmationToken = confirmationTokenService.saveConfirmationToken(buildConfirmationToken(appUser));
        String link = baseUrl.concat(confirmationToken.getToken());
        awsEmailServiceImpl.sendMail(appUser.getEmail(), EmailUtil.buildEmail(appUser.getFirstName().concat(" ").concat(appUser.getLastName()),link));
        return SignupResponse.builder().responseCode(SUCCESS).message(SUCCESS_SIGNUP_MESSAGE).time(LocalDateTime.now()).build();
    }

    private ConfirmationToken buildConfirmationToken(AppUser appUser) {
        return ConfirmationToken.builder().expiredAt(LocalDateTime.now().plusMinutes(30))
                .token(UUID.randomUUID().toString()).user(appUser).build();
    }

    private void validateUsersEmail(String email) {
        if(appUserRepository.findByEmail(email).isPresent()){
            throw new RuntimeException("");
        }
    }

    @Override
    public SignupResponse confirmToken(String token) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public AppUserDTO convertEntityToData(AppUser appUser) {
        return null;
    }

    @Override
    public AppUser convertDataToEntity(AppUserDTO appUserDTO) {
        return null;
    }
}
