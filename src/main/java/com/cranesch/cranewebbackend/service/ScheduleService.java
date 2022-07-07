package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.TimeScheduleDto;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.TimescheduleRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleService {
    private TimescheduleRepository timescheduleRepository;
    private UserRepository userRepository;

    @Transactional
    public Long CreateTimeSchedule(TimeScheduleDto dto, Long User_id)
    {
        Optional<User> optionalUser = userRepository.findById(User_id);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User not Found");
        }
        dto.setUser(optionalUser.get());

        return timescheduleRepository.save(dto.toEntity()).getTime_id();
    }

}
