package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    List<Picture> findByboardId(Long id);
}
