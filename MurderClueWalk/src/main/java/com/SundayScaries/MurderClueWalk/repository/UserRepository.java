package com.SundayScaries.MurderClueWalk.repository;

import com.SundayScaries.MurderClueWalk.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}