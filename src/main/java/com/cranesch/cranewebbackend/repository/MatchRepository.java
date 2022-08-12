package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByTeamId(Long teamId);
    List<Match> findByUserId(Long userId);
}
