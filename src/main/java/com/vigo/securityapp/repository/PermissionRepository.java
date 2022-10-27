package com.vigo.securityapp.repository;

import com.vigo.securityapp.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
