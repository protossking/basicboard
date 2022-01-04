package com.board.web;


import com.board.domain.BoardEntity;
import com.board.domain.MemberEntity;
import com.board.service.BoardDetail;
import com.board.service.BoardService;
import com.board.web.dto.board.BoardDetailResponseDto;
import com.board.web.dto.board.BoardListResponseDto;
import com.board.web.dto.board.BoardSaveRequestDto;
import com.board.web.dto.board.BoardUpdateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Api("BoardController V1")
@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService service;



    @ApiOperation(value = "게시판 목록", notes = "게시판 전체 목록을 보여준다 ")
    @GetMapping("/api/v1/boards")
    public List<BoardListResponseDto> listAll() {
        return service.findAll();

    }
    @ApiOperation(value = "게시판 등록", notes = "게시글을 등록한다")
    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto request,
                     @SessionAttribute(name = "LOGINMEMBER") MemberEntity memberEntity) {

        if(memberEntity.getMemberId().equals(null)) {
            throw new IllegalArgumentException("권한이 없습니다");
        }
        return service.write(request.toParam(),  memberEntity.getMemberId());
    }

    @GetMapping("/api/v1/board/{boardNo}")
    @ApiOperation(value = "게시판 상세보기 ", notes = "해당 게시판 숫자 보여줌 ")
    public BoardDetailResponseDto getBoardDetail(@PathVariable Long boardNo) {
        BoardDetail board= service.getBoard(boardNo);
        return new BoardDetailResponseDto(board);
    }

    @ApiOperation(value = "게시판 수정", notes = "해당 게시판을 수정한다. ")
    @PutMapping("/api/v1/board/{boardNo}")
    public ResponseEntity modifiedBoard(@PathVariable Long boardNo,
                                        @RequestBody BoardUpdateRequestDto request,
                                        @SessionAttribute(name = "LOGINMEMBER") MemberEntity memberEntity) {
        if(!request.getMemberId().equals(memberEntity.getMemberId())) {
            throw new RuntimeException("권한이 없습니다");
        }
        service.modifiedBoard(boardNo, request.toParam());

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/board/{boardNo}")
    @ApiOperation(value = "게시판 삭제", notes = "해당 게시글을 삭제한다 ")
    public ResponseEntity deleteBoard(@PathVariable Long boardNo, String memberId) {
        service.deleteBoard(boardNo, memberId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/v2/boards")
    public ResponseEntity listPaging(Pageable pageable) {
        Page<BoardEntity> allPage = service.findAll(pageable);
        return new ResponseEntity<>(allPage, HttpStatus.OK);
    }








}


