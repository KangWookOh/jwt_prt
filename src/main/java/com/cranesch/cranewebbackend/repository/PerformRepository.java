package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Perform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformRepository extends JpaRepository<Perform, Long> {
}
