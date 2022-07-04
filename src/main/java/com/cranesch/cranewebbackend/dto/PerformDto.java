package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Perform;
import com.cranesch.cranewebbackend.entity.enums.Perform_Type;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PerformDto {

    private String Perform_name;

    private LocalDate Perform_date;

    private Perform_Type perform_type;

    private String Perform_place;

    public Perform toEntity(){
        return Perform.builder()
                .Perform_name(Perform_name)
                .Perform_place(Perform_place)
                .Perform_date(Perform_date)
                .perform_type(perform_type)
                .build();
    }
}
