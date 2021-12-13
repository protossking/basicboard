package com.board.service;

import com.board.domain.Board;
import com.board.domain.BoardRepository;
import com.board.domain.Member;
import com.board.domain.MemberRepository;
import com.board.web.dto.board.BoardListResponseDto;
import com.board.web.dto.board.BoardSaveRequestDto;
import com.board.web.dto.board.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;
    private final MemberRepository memberRepository;



    @Transactional
    public Long write(BoardSaveRequestDto dto) {
        Board save = repository.save(dto.toEntity());
        return save.getNo();
    }

    @Transactional
    public Long update(Long no, BoardUpdateRequestDto dto) {
        Board board = repository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 게시글 없습니다"));
        board.update(dto.getTitle(), dto.getContent());
        return no;
    }

    @Transactional
    public List<BoardListResponseDto> findAll() {
        List<BoardListResponseDto> collect = repository.findAll().stream().map(BoardListResponseDto::new).collect(Collectors.toList());
        return collect;
    }

    @Transactional
    public void delete(Long no) {
        Board board  =  repository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 "));
        repository.delete(board);

    }

}
