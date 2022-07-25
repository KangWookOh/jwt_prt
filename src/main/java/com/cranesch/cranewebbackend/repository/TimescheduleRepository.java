package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Timeschedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimescheduleRepository extends JpaRepository<Timeschedule, Long> {
    List<Timeschedule> findByUserId(Long userId);
}
