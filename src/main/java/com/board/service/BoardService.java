package com.board.service;

import com.board.domain.BoardEntity;
import com.board.domain.BoardRepository;
import com.board.domain.MemberEntity;
import com.board.domain.MemberRepository;
import com.board.service.param.BoardSaveParam;
import com.board.service.param.BoardUpdateParam;
import com.board.web.dto.board.BoardDetailResponseDto;
import com.board.web.dto.board.BoardListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;



    @Transactional
    public Long write(BoardSaveParam params, String memberId) {

        MemberEntity findedMember = memberRepository.findByMemberId(memberId);
        BoardEntity board = boardRepository.save(params.toEntity(findedMember));

        return board.getBoardId();

    }

    @Transactional
    public List<BoardListResponseDto> findAll() {
        List<BoardListResponseDto> collect = boardRepository.findAll().stream().map(BoardListResponseDto::new).collect(Collectors.toList());
        return collect;
    }

    @Transactional
    public void delete(Long no) {
        BoardEntity board  =  boardRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 "));
        boardRepository.delete(board);

    }

    @Transactional
    public BoardDetail getBoard(Long boardNo) {

        BoardEntity board = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글번호가없음 "));

        return new BoardDetail(board);
    }

    @Transactional
    public void modifiedBoard(Long boardNo, BoardUpdateParam param) {
        BoardEntity findedBoard = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다"));
        findedBoard.update(param.getTitle(), param.getContent());
    }

    @Transactional
    public Long deleteBoard(Long boardNo, String memberId) {
        MemberEntity findMemberEntity = memberRepository.findByMemberId(memberId);
        BoardEntity board = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 "));

        if(findMemberEntity.getMemberId().equals(board.getMemberEntity().getMemberId())) {
            boardRepository.delete(board);
        }
        return boardNo;

    }

    public Page<BoardEntity> findAll(@PageableDefault(value = 10) Pageable pageable) {
        Page<BoardEntity> all = boardRepository.findAll(pageable);
        return all;


    }


}
