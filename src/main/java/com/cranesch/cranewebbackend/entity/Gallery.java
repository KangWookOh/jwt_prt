package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.Gallery_Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Gallery_id;

    @Column(nullable = false)
    private String Gallery_title;

    @Column(nullable = false, columnDefinition = "Text")
    private String Gallery_content;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gallery_Type gallery_type;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    User user;

    @OneToOne
    Music music;

    @Builder
    public Gallery(String title, String contents, Gallery_Type type){
        this.Gallery_title = title;
        this.Gallery_content = contents;
        this.gallery_type = type;
    }
}
