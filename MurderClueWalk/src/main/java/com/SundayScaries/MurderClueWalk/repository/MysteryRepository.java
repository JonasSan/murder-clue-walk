package com.SundayScaries.MurderClueWalk.repository;

import com.SundayScaries.MurderClueWalk.domain.Mystery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysteryRepository extends JpaRepository<Mystery, Long> {
}
