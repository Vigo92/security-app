package com.vigo.securityapp.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permission")
@Entity
@Getter
@Setter
public class Permission extends BaseEntity{

    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "permissions", fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();
}
