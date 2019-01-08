package com.SundayScaries.MurderClueWalk.repository;

import com.SundayScaries.MurderClueWalk.domain.Clue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClueRepository extends JpaRepository<Clue, Long> {
}
