package com.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {


//    @Query("select b from Board b order by b.id desc")
//    List<Board> findAllDesc();


//    Page<Board> findPage(Pageable pageable);



}
