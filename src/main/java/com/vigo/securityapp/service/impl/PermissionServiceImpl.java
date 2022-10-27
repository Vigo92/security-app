package com.vigo.securityapp.service.impl;

import com.vigo.securityapp.model.dto.PermissionDTO;
import com.vigo.securityapp.model.entity.Permission;
import com.vigo.securityapp.repository.PermissionRepository;
import com.vigo.securityapp.service.BaseService;
import com.vigo.securityapp.service.PermissionService;
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
public class PermissionServiceImpl implements PermissionService, BaseService<Permission, PermissionDTO> {

    private final PermissionRepository permissionRepository;


    @Override
    public PermissionDTO convertEntityToData(Permission permission) {
        return null;
    }

    @Override
    public Permission convertDataToEntity(PermissionDTO permissionDTO) {
        return null;
    }
}
