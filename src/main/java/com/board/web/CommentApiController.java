package com.board.web;

import com.board.domain.Comment;
import com.board.domain.Member;
import com.board.service.CommentService;
import com.board.web.dto.comment.CommentSaveRequestDto;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@ApiOperation("Comment service")
public class CommentApiController {

    private final CommentService commentService;


    @PostMapping("/api/v1/comment")
    @ApiOperation(value = "댓글 등록", notes = "댓글 등록을 한다 ")
    public ResponseEntity write(@RequestBody CommentSaveRequestDto dto, Long boardNo, @SessionAttribute(name = "LOGINMEMBER") Member memebr) {

        Long write = commentService.write(dto, boardNo, memebr);
        return new ResponseEntity(write, HttpStatus.OK);
    }

}
