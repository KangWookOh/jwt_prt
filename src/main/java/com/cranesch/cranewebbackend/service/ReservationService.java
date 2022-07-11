package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.EventDto;
import com.cranesch.cranewebbackend.dto.ReservationDto;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.EventRepository;
import com.cranesch.cranewebbackend.repository.ReservationRepository;
import com.cranesch.cranewebbackend.repository.TeamRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {

    private TeamRepository teamRepository;
    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private EventRepository eventRepository;

    @Transactional
    public Long CreateTeamReservation(ReservationDto dto, Long teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isEmpty()) {
            throw new EntityExistsException("Team not exist");
        }
        dto.setTeam(optionalTeam.get());

        return reservationRepository.save(dto.toEntity()).getId();
    }


    @Transactional
    public Long CreateUserReservation(ReservationDto dto, Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new EntityExistsException("User not exist");
        }
        dto.setUser(optionalUser.get());

        return reservationRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long CreateEvent(EventDto dto, Long userId, Long teamId)
    {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new EntityExistsException("User not found.");
        }

        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if(optionalTeam.isEmpty())
        {
            throw new EntityExistsException("Team not found");
        }

        dto.setUser(optionalUser.get());
        dto.setTeam(optionalTeam.get());
        return eventRepository.save(dto.toEntity()).getId();
    }
}