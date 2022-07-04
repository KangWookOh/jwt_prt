package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
