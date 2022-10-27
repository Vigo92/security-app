package com.vigo.securityapp.service;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/
public interface BaseService<T,R> {

    R convertEntityToData(T t);

    T convertDataToEntity(R r);
}
