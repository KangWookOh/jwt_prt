package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByTeamId(Long teamId);
}
