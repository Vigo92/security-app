package com.vigo.securityapp.service;

import com.vigo.securityapp.model.entity.ConfirmationToken;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/
public interface ConfirmationTokenService {


    ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken);

    int updateConfirmationToken(String token, LocalDateTime confirmedAt);
}
