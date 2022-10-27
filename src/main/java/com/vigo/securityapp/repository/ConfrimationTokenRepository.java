package com.vigo.securityapp.repository;

import com.vigo.securityapp.model.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/
public interface ConfrimationTokenRepository extends JpaRepository<ConfirmationToken, Long> {


    Optional<ConfirmationToken> findByToken(String token);

    @Modifying
    @Transactional
    @Query("update ConfirmationToken  c set c.confirmedAt = ?2 where c.token = ?1")
    int updateConfirmationToken(String token, LocalDateTime confirmedAt);
}
