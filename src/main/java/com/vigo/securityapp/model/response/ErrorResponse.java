package com.vigo.securityapp.model.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 27/10/2022
 **/

@Data
@Builder
public class ErrorResponse {

    private String message;

    private String code;

    private LocalDateTime time;
}
