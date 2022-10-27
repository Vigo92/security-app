package com.vigo.securityapp.exception;

import com.vigo.securityapp.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 27/10/2022
 **/

@RestControllerAdvice
public class AppException {




    @ExceptionHandler({JWTAuthenticationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse jWTAuthenticationException(JWTAuthenticationException jwtAuthenticationException){

        return ErrorResponse.builder().code("99").message(jwtAuthenticationException.getMessage())
                .time(LocalDateTime.now()).build();
    }
}
