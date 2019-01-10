package com.SundayScaries.MurderClueWalk.repository;

import com.SundayScaries.MurderClueWalk.domain.Clue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClueRepository extends JpaRepository<Clue, Long> {
    Optional<Clue> findByClueText(String clueText);
}
