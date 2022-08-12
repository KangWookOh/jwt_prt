package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    //List<Team> findByMatchId(Long matchId);
}
