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
        return equipmentRepository.save(dto.toEntity()).getEqId();
    }

    @Transactional
    public Long CreateEqR(EqRepairDto dto, Long eqId)
    {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(eqId);
        if(!optionalEquipment.isPresent()){
            throw new EntityExistsException("Eq is not exist");
        }
        dto.setEqId(optionalEquipment.get());
        return eqRepairRepository.save(dto.toEntity()).getEqrId();
    }
}
