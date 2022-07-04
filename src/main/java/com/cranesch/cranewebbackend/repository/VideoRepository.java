package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
