package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
