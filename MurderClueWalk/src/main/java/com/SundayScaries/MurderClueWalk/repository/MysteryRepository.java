package com.SundayScaries.MurderClueWalk.repository;

import com.SundayScaries.MurderClueWalk.domain.Mystery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MysteryRepository extends JpaRepository<Mystery, Long> {
    Optional<Mystery> findByMysteryName(String mysteryName);
}
