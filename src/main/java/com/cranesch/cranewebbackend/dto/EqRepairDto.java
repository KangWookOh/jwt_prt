package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.EqRepair;
import com.cranesch.cranewebbackend.entity.Equipment;
import lombok.Data;

@Data
public class EqRepairDto {
    
    private String eqrDate;

    private String eqrPrice;

    private String eqrMemo;

    private Equipment eqId;

    public EqRepair toEntity()
    {
        return EqRepair.builder().
                eqrDate(eqrDate).
                eqrPrice(eqrPrice).
                eqrMemo(eqrMemo).
                eqId(eqId).
                build();
    }
}
