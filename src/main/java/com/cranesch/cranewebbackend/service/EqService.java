package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.EqRepairDto;
import com.cranesch.cranewebbackend.dto.EquipmentDto;
import com.cranesch.cranewebbackend.entity.Equipment;
import com.cranesch.cranewebbackend.repository.EqRepairRepository;
import com.cranesch.cranewebbackend.repository.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EqService {
    private EquipmentRepository equipmentRepository;
    private EqRepairRepository eqRepairRepository;

    @Transactional
    public Long CreateEq(EquipmentDto dto){
        return equipmentRepository.save(dto.toEntity()).getEq_id();
    }

    @Transactional
    public Long CreateEqR(EqRepairDto dto, Long Eq_id)
    {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(Eq_id);
        if(!optionalEquipment.isPresent()){
            throw new EntityExistsException("Eq is not exist");
        }
        dto.setEq_id(optionalEquipment.get());
        return eqRepairRepository.save(dto.toEntity()).getEqR_id();
    }
}
