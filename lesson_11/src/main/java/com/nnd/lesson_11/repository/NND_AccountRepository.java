package com.nnd.lesson_11.repository;

import com.nnd.lesson_11.entity.NND_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NND_AccountRepository extends JpaRepository<NND_Account, Long> {
}