package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.EqRepair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EqRepairRepository extends JpaRepository<EqRepair, Long> {
    List<EqRepair> findByEquipmentId(Long EqId);
}
