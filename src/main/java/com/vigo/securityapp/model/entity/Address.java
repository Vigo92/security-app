package com.vigo.securityapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String address;

    private String city;

    private String name;
}
