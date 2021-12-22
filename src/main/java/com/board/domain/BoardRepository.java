package com.board.domain;

import com.board.web.dto.board.BoardListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {


//    @Query("select b from Board b order by b.id desc")
//    List<Board> findAllDesc();


//    Page<Board> findPage(Pageable pageable);



}
