package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
