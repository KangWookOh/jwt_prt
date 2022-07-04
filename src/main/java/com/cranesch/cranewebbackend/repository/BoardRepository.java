package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
