package com.board.service;

import com.board.domain.BoardEntity;
import com.board.domain.BoardRepository;
import com.board.domain.Member;
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
        Member member = memberRepository.findByMemberId(memberId);
        BoardEntity saveBoardEntity = boardRepository.save(dto.toEntity(member));
        return saveBoardEntity.getBoardId();
    }

    @Transactional
    public Long update(Long no, BoardUpdateRequestDto dto) {
        BoardEntity boardEntity = boardRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 게시글 없습니다"));
        boardEntity.update(dto.getTitle(), dto.getContent());
        return no;
    }

    @Transactional
    public List<BoardListResponseDto> findAll() {
        List<BoardListResponseDto> collect = boardRepository.findAll().stream().map(BoardListResponseDto::new).collect(Collectors.toList());
        return collect;
    }

    @Transactional
    public void delete(Long no) {
        BoardEntity boardEntity = boardRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 "));
        boardRepository.delete(boardEntity);

    }

    @Transactional
    public BoardDetail getBoard(Long boardNo) {
        BoardEntity boardEntity = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글번호가없음 "));
        return new BoardDetail(boardEntity);
    }

    @Transactional
    public void modifiedBoard(Long boardNo, BoardUpdateParam param) {
        BoardEntity boardEntity = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글이없습니다 "));
        boardEntity.update(param.getTitle(), param.getContent());
    }

    @Transactional
    public Long deleteBoard(Long boardNo, String memberId) {
        Member findMember = memberRepository.findByMemberId(memberId);
        BoardEntity boardEntity = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 "));

        if (findMember.getMemberId().equals(boardEntity.getMember().getMemberId())) {
            boardRepository.delete(boardEntity);
        }
        return boardNo;

    }

    public Page<BoardEntity> findAll(@PageableDefault(value = 10) Pageable pageable) {
        Page<BoardEntity> all = boardRepository.findAll(pageable);
        return all;


    }


}
