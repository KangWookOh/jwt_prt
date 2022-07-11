package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByBoardId(Long boardId);
}
