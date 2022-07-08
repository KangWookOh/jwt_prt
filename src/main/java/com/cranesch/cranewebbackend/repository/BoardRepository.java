package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.enums.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByBoardType(BoardType boardType);
    List<Board> findByUserIdUserId(Long userId);
}
