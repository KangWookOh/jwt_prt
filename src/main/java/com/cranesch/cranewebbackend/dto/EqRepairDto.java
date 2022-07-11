package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.EqRepair;
import com.cranesch.cranewebbackend.entity.Equipment;
import lombok.Data;

@Data
public class EqRepairDto {
    
    private String eqrDate;

    private String eqrPrice;

    private String eqrMemo;

    private Equipment equipment;

    public EqRepair toEntity()
    {
        return EqRepair.builder().
                eqrDate(eqrDate).
                eqrPrice(eqrPrice).
                eqrMemo(eqrMemo).
                equipment(equipment).
                build();
    }
}
