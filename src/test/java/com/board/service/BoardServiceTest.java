package com.board.service;

import com.board.domain.BoardEntity;
import com.board.domain.BoardRepository;
import com.board.domain.Member;
import com.board.domain.MemberRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class BoardServiceTest {

    @Test
    void getBoard_결과테스트() {
        // given
        BoardRepository boardRepository = mock(BoardRepository.class);
        given(boardRepository.findById(any())).willReturn(board());
        BoardService sut = new BoardService(boardRepository, mock(MemberRepository.class));

        // when
        BoardDetail board = sut.getBoard(1L);

        // then
        assertThat(board.getBoardNo()).isEqualTo(1L);
    }

    @Test
    void getBoard_행동테스트() {
        // given
        BoardRepository boardRepository = mock(BoardRepository.class);
        given(boardRepository.findById(any())).willReturn(board());

        BoardService sut = new BoardService(boardRepository, mock(MemberRepository.class));

        // when
        BoardDetail board = sut.getBoard(1L);

        // then
        verify(boardRepository, times(1)).findById(1L);
    }

    private Optional<BoardEntity> board() {
        return Optional.of(BoardEntity.builder()
                .boardId(1L)
                .member(Member.builder().build())
                .build());
    }
}