package com.vigo.securityapp.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
@Entity
@Getter
@Setter
public class Role extends BaseEntity{

    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<AppUser> user = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name="role_id")
    ,inverseJoinColumns = @JoinColumn(name="permission_id"))
    private Set<Permission> permissions = new HashSet<>();


}
