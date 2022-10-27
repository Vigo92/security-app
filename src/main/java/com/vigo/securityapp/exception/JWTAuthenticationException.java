package com.vigo.securityapp.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 22/10/2022
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JWTAuthenticationException extends RuntimeException {

    private String message;
}
