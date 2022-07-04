package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.BoardDto;
import com.cranesch.cranewebbackend.dto.ReplyDto;
import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.BoardRepository;
import com.cranesch.cranewebbackend.repository.ReplyRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;
    private ReplyRepository replyRepository;
    private UserRepository userRepository;

    @Transactional
    public Long CreateBoard(BoardDto dto, Long User_id)
    {
        Optional<User> optionalUser = userRepository.findById(User_id);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User not exist.");
        }
        dto.setUser_id(optionalUser.get());

    return boardRepository.save(dto.toEntity()).getBoard_id();
    }

    @Transactional
    public Long CreateReply(ReplyDto replyDto, Long user_id, Long board_id){
        Optional<User> optionalUser = userRepository.findById(user_id);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User is not exist");
        }

        Optional<Board> optionalBoard = boardRepository.findById(board_id);
        if(!optionalBoard.isPresent()){
            throw new EntityExistsException("Board is not exist");
        }

        replyDto.setBoard(optionalBoard.get());
        replyDto.setUser(optionalUser.get());
        return replyRepository.save(replyDto.toEntity()).getReply_id();
    }
}
