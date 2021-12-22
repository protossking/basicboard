package com.board.web;


import com.board.domain.Board;
import com.board.domain.Member;
import com.board.service.BoardService;
import com.board.web.dto.board.BoardDetailResponseDto;
import com.board.web.dto.board.BoardListResponseDto;
import com.board.web.dto.board.BoardSaveRequestDto;
import com.board.web.dto.board.BoardUpdateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("BoardControlelr V1")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    @GetMapping("/api/v1/boards")
    @ApiOperation(value = "게시판 목록", notes = "게시판 전체 목록을 보여준다 ")
    public List<BoardListResponseDto> listAll() {
        List<BoardListResponseDto> all = service.findAll();
        return all;
    }

    @PostMapping("/api/v1/board")
    public Long save(
            @RequestBody BoardSaveRequestDto dto,
            @SessionAttribute(name = "LOGINMEMBER") Member member
    ) {
        return service.write(dto, member.getMemberId());
    }

    @GetMapping("/api/v1/board/{boardNo}")
    @ApiOperation(value = "게시판 상세보기 ", notes = "해당 게시판 숫자 보여줌 ")
    public BoardDetailResponseDto getBoardDetail(
            @PathVariable Long boardNo
    ) {
        return service.getBoard(boardNo);
    }

    @PutMapping("/api/v1/board/{boardNo}")
    @ApiOperation(value = "게시판 수정", notes = "해당 게시판을 수정한다. ")
    public void modifiedBoard(
            @PathVariable Long boardNo,
            @RequestBody BoardUpdateRequestDto request,
            @SessionAttribute(name = "LOGINMEMBER") Member member
    ) {
        service.modifiedBoard(request, member.getMemberId(), boardNo);
    }

    @DeleteMapping("/api/v1/board/{boardNo}")
    @ApiOperation(value = "게시판 삭제", notes = "해당 게시글을 삭제한다 ")
    public ResponseEntity deleteBoard(
            @PathVariable Long boardNo,
            String memberId
    ) {
        service.deleteBoard(boardNo, memberId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/v2/boards")
    public ResponseEntity listPaging(Pageable pageable) {
        Page<Board> allPage = service.findAll(pageable);
        return new ResponseEntity<>(allPage, HttpStatus.OK);
    }
}


