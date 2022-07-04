package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.EqRepair;
import com.cranesch.cranewebbackend.entity.Equipment;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EqRepairDto {
    
    private String EqR_date;

    private String EqR_price;

    private String EqR_memo;

    private Equipment Eq_id;

    public EqRepair toEntity()
    {
        return EqRepair.builder().
                EqR_date(EqR_date).
                EqR_price(EqR_price).
                EqR_memo(EqR_memo).
                Eq_id(Eq_id).
                build();
    }
}
