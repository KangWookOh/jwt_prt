package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByboardId(Long id);
}
