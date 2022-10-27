package com.vigo.securityapp.model.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/

@Builder
@Data
public class SignupResponse {

    private String message;

    private String responseCode;

    private LocalDateTime time;
}
