package com.vigo.securityapp.service.impl;

import com.vigo.securityapp.model.dto.RoleDTO;
import com.vigo.securityapp.model.entity.Role;
import com.vigo.securityapp.repository.RoleRepository;
import com.vigo.securityapp.service.BaseService;
import com.vigo.securityapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService, BaseService <Role, RoleDTO> {

    private final RoleRepository roleRepository;

    @Override
    public RoleDTO convertEntityToData(Role role) {
        return null;
    }

    @Override
    public Role convertDataToEntity(RoleDTO roleDTO) {
        return null;
    }
}
