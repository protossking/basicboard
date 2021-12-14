package com.board.web;


import com.board.domain.Member;
import com.board.service.BoardService;
import com.board.web.dto.board.BoardDetailResponseDto;
import com.board.web.dto.board.BoardListResponseDto;
import com.board.web.dto.board.BoardSaveRequestDto;
import com.board.web.dto.board.BoardUpdateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
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
    public List<BoardListResponseDto> listAll() {
        List<BoardListResponseDto> all = service.findAll();

        return all;
    }

    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto dto, String memberId ) {

        return service.write(dto, memberId);

    }

    @GetMapping("/api/v1/board/{boardNo}")
    public ResponseEntity getBoardDetail(@PathVariable Long boardNo) {
        BoardDetailResponseDto board = service.getBoard(boardNo);
        return new ResponseEntity(board, HttpStatus.OK);
    }

    @PutMapping("/api/v1/board/{boardNo}")
    public ResponseEntity modifiedBoard(@PathVariable Long boardNo, BoardUpdateRequestDto dto, String memberId) {


        service.modifiedBoard(dto, memberId, boardNo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/board/{boardNo}")
    public ResponseEntity deleteBoard(@PathVariable Long boardNo, String memberId) {
        service.deleteBoard(boardNo, memberId);

        return new ResponseEntity(HttpStatus.OK);
    }








}


