package com.board.service;

import com.board.domain.Board;
import com.board.domain.BoardRepository;
import com.board.domain.Member;
import com.board.domain.MemberRepository;
import com.board.web.dto.board.BoardDetailResponseDto;
import com.board.web.dto.board.BoardListResponseDto;
import com.board.web.dto.board.BoardSaveRequestDto;
import com.board.web.dto.board.BoardUpdateRequestDto;
import io.swagger.models.Model;
import io.swagger.models.Path;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;



    @Transactional
    public Long write(BoardSaveRequestDto dto, String memberId) {

        Member findMember = memberRepository.findByMemberId(memberId);
        dto.setMember(findMember);
        Board saveBoard = boardRepository.save(dto.toEntity());
        return saveBoard.getBoardId();
    }

    @Transactional
    public Long update(Long no, BoardUpdateRequestDto dto) {
        Board board = boardRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 게시글 없습니다"));
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
        Board board  =  boardRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 "));
        boardRepository.delete(board);

    }

    @Transactional
    public BoardDetailResponseDto getBoard(Long boardNo) {

        Board board = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글번호가없음 "));
        return new BoardDetailResponseDto(board);
    }

    @Transactional
    public void modifiedBoard(BoardUpdateRequestDto dto, String memberId, Long boardNo) {

        Member findMember = memberRepository.findByMemberId(memberId);
        dto.setMemberId(findMember.getMemberId());
        Board findBoard = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글이없습니다 "));


        if(findMember.getMemberId().equals(findBoard.getMember().getMemberId())) {
            findBoard.update(dto.getTitle(), dto.getContent());
        }
    }

    @Transactional
    public Long deleteBoard(Long boardNo, String memberId) {
        Member findMember = memberRepository.findByMemberId(memberId);
        Board board = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 "));

        if(findMember.getMemberId().equals(board.getMember().getMemberId())) {
            boardRepository.delete(board);
        }
        return boardNo;

    }

    public Page<Board> findAll(@PageableDefault(value = 10) Pageable pageable) {
        Page<Board> all = boardRepository.findAll(pageable);
        return all;


    }


}
