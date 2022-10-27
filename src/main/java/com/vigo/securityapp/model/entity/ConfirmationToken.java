package com.vigo.securityapp.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "confirmation_token",uniqueConstraints = @UniqueConstraint(columnNames = {"token"}))
@Entity
@Setter
@Getter
@Builder
public class ConfirmationToken  extends BaseEntity{


    private String token;

    @ManyToOne
    private AppUser user;

    private LocalDateTime confirmedAt;

    private LocalDateTime expiredAt;
}
