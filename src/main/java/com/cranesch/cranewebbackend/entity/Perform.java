package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.PerformType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Perform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String performName;

    private LocalDateTime performDate;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)//추후 create drop 후
    private PerformType performType;

    private String performPlace;

    public void updatePerform(String performName, String performPlace, LocalDateTime performDate, PerformType performType){
        this.performName = performName;
        this.performPlace = performPlace;
        this.performType = performType;
        this.performDate = performDate;
    }

    @Builder
    public Perform(String performName, LocalDateTime performDate, PerformType performType, String performPlace){
        this.performName = performName;
        this.performDate = performDate;
        this.performType = performType;
        this.performPlace = performPlace;
    }
}
