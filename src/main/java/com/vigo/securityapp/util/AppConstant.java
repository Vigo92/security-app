package com.vigo.securityapp.util;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 22/10/2022
 **/
public interface AppConstant {

    static int INIT = 1;
    static String SYSTEM_USER = "system";
    static final int EXPIRATION = 60 * 24;
    static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    static final short STRING_SIZE = 7;
    static final String TOKEN_INVALID = "invalid token";
    static final String TOKEN_EXPIRED = "expired";
    static final String TOKEN_VALID = "valid";
    static final String UTF_8 = "UTF-8";
}
