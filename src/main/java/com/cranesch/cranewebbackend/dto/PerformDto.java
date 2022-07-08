package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Perform;
import com.cranesch.cranewebbackend.entity.enums.PerformType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PerformDto {

    private String performName;

    private LocalDateTime performDate;

    private PerformType performType;

    private String performPlace;

    public Perform toEntity(){
        return Perform.builder()
                .performName(performName)
                .performPlace(performPlace)
                .performDate(performDate)
                .performType(performType)
                .build();
    }
}
