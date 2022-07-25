package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.Gallery;
import com.cranesch.cranewebbackend.entity.enums.GalleryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    List<Gallery> findBygalleryType(GalleryType galleryType);
    List<Gallery> findByMusicId(Long id);
}
