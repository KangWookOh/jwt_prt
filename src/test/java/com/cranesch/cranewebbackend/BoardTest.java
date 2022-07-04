package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.BoardDto;
import com.cranesch.cranewebbackend.dto.ReplyDto;
import com.cranesch.cranewebbackend.entity.enums.Board_Type;
import com.cranesch.cranewebbackend.repository.BoardRepository;
import com.cranesch.cranewebbackend.service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardTest {
    
    @Autowired
    private BoardService boardService;
    
    
    @Test
    public void BoardCreateTest()
    {
        BoardDto bdto = new BoardDto();
        bdto.setBoard_title("Test Board");
        bdto.setBoard_contents("We're testing Board");
        bdto.setBoard_type(Board_Type.ADMIN);

        boardService.CreateBoard(bdto, Long.valueOf(1));
    }
    
    @Test
    public void ReplyCreateTest(){
        ReplyDto replyDto = new ReplyDto();
        replyDto.setReply_comment("comment body");
        
        boardService.CreateReply(replyDto,Long.valueOf(1), Long.valueOf(1));
    }
}
