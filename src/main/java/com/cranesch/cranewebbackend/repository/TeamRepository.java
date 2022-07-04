package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
