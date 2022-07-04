package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
