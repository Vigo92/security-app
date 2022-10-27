package com.vigo.securityapp.service.impl;

import com.vigo.securityapp.model.dto.ConfirmationTokenDTO;
import com.vigo.securityapp.model.entity.ConfirmationToken;
import com.vigo.securityapp.repository.ConfrimationTokenRepository;
import com.vigo.securityapp.service.BaseService;
import com.vigo.securityapp.service.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService, BaseService<ConfirmationToken, ConfirmationTokenDTO> {

    private final ConfrimationTokenRepository confrimationTokenRepository;

    @Override
    public ConfirmationTokenDTO convertEntityToData(ConfirmationToken confirmationToken) {
        return null;
    }

    @Override
    public ConfirmationToken convertDataToEntity(ConfirmationTokenDTO confirmationTokenDTO) {
        return null;
    }

    @Override
    public ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken) {
        return null;
    }

    @Override
    public int updateConfirmationToken(String token, LocalDateTime confirmedAt) {
        return 0;
    }
}
