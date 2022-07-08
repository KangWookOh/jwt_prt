package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Equipment;
import com.cranesch.cranewebbackend.entity.enums.Session;
import lombok.Data;

@Data
public class EquipmentDto {

    private String eqName;

    private String eqBirth;

    private Session eqSession;

    public Equipment toEntity()
    {
        return Equipment.builder().
                eqName(eqName).
                eqBirth(eqBirth).
                eqSession(eqSession).
                build();
    }

}
