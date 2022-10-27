package com.vigo.securityapp.model.entity;

import com.vigo.securityapp.model.constant.Gender;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user",uniqueConstraints = @UniqueConstraint(columnNames = {"email", "username"}))
@Entity
@Setter
@Getter
public class AppUser extends BaseEntity implements UserDetails {


    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String userName;

    private boolean enabled = false;

    private boolean locked = false;

    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.MALE;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @Embedded
    private Address address;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
