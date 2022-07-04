package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
