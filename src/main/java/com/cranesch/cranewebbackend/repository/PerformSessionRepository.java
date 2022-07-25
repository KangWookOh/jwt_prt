package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.dto.PerformSessionDto;
import com.cranesch.cranewebbackend.entity.PerformSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformSessionRepository extends JpaRepository<PerformSession, Long> {
    List<PerformSession> findByUserId(Long userId);
    List<PerformSession> findByMusicId(Long musicId);
}
