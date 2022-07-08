package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.BoardDto;
import com.cranesch.cranewebbackend.dto.ReplyDto;
import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.Reply;
import com.cranesch.cranewebbackend.entity.enums.BoardType;
import com.cranesch.cranewebbackend.service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardTest {
    
    @Autowired
    private BoardService boardService;
    
    
    @Test
    public void BoardCreateTest()
    {
        for(int i =0; i < 10; i++) {
            BoardDto bdto = new BoardDto();
            bdto.setBoardTitle("Admin Board" + i );
            bdto.setBoardContents("We're testing Board" + i);
            bdto.setBoardType(BoardType.ADMIN);

            boardService.CreateBoard(bdto, Long.valueOf(5));
        }
    }
    
    @Test
    public void ReplyCreateTest(){
        ReplyDto replyDto = new ReplyDto();
        replyDto.setReplyComment("댓글 추가 함");
        
        boardService.CreateReply(replyDto,Long.valueOf(2), Long.valueOf(1));
    }

    @Test
    public void ReadBoardByType(){
        List<Board> boardList = boardService.ReadBoardByType(BoardType.ADMIN);
        int i = 1;
        for(Board b : boardList){
            System.out.printf(i++ + "번째 보드입니다  // id:" + b.getBoardId() + "// type: " + b.getBoardType() + " // title: " + b.getBoardTitle() + "\n");
        }
    }

    @Test
    public void ReadBoardAndReplyByBoardId(){
        Long boardId = Long.valueOf(1);
        Board board = boardService.ReadBoardById(boardId);
        List<Reply> replyList = boardService.ReadReplyByBoardId(boardId);

        System.out.printf("제목: " + board.getBoardTitle() + "타입 : " + board.getBoardType() + "\n");
        System.out.printf("내용: " + board.getBoardContents() + "\n");
        System.out.printf("조회수 : " + board.getBoardView() + "\n" + "=====  댓글 =====" + "\n" );

        int i = 1;
        for(Reply r : replyList){
            System.out.printf("댓글 " + i + " : " + r.getReplyComment() + "\n" );
        }
    }


    @Test
    public void ReadBoardByUser()
    {
        List<Board> UboardList = boardService.ReadBoardByUser(Long.valueOf(5));

        int i=0;
        for(Board b :UboardList){
            System.out.printf("User : " + b.getUserId().getUserName() + " / Title :" +
                    b.getBoardTitle() + " / content : " + b.getBoardContents() +
                    " / boardCount : " + i + "\n");
        }
    }
}
