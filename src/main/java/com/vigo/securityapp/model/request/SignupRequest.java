package com.vigo.securityapp.model.request;

import lombok.Data;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/

@Data
public class SignupRequest {

    private String email;

    private String password;
}
