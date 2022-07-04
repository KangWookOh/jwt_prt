package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Equipment;
import com.cranesch.cranewebbackend.entity.enums.Session;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EquipmentDto {

    private String Eq_name;

    private LocalDateTime Eq_birth;

    private Session Eq_Session;

    private Equipment toEntity()
    {
        return Equipment.builder().
                Eq_name(Eq_name).
                Eq_birth(Eq_birth).
                Eq_Session(Eq_Session).
                build();
    }

}
