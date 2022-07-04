package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
