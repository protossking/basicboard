package com.board.service;

import com.board.domain.BoardEntity;
import com.board.domain.BoardRepository;
import com.board.domain.MemberEntity;
import com.board.domain.MemberRepository;
import com.board.web.dto.board.BoardDetailResponseDto;
import com.board.web.dto.board.BoardListResponseDto;
import com.board.web.dto.board.BoardSaveRequestDto;
import com.board.web.dto.board.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;



    @Transactional
    public Long write(BoardSaveRequestDto dto, String memberId) {

        MemberEntity findMemberEntity = memberRepository.findByMemberId(memberId);
        dto.setMemberEntity(findMemberEntity);
        BoardEntity saveBoard = boardRepository.save(dto.toEntity());
        return saveBoard.getBoardId();
    }

    @Transactional
    public Long update(Long no, BoardUpdateRequestDto dto) {
        BoardEntity board = boardRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 게시글 없습니다"));
        board.update(dto.getTitle(), dto.getContent());
        return no;
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
    public BoardDetailResponseDto getBoard(Long boardNo) {

        BoardEntity board = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글번호가없음 "));
        return new BoardDetailResponseDto(board);
    }

    @Transactional
    public void modifiedBoard(BoardUpdateRequestDto dto, String memberId, Long boardNo) {

        MemberEntity findMemberEntity = memberRepository.findByMemberId(memberId);
        dto.setMemberId(findMemberEntity.getMemberId());
        BoardEntity findBoard = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글이없습니다 "));


        if(findMemberEntity.getMemberId().equals(findBoard.getMemberEntity().getMemberId())) {
            findBoard.update(dto.getTitle(), dto.getContent());
        }
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
