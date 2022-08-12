package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    List<Music> findByPerformId(Long id);
    List<Music> findByTeamId(Long id);
}
