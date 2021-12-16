package com.board.domain;

import com.board.web.dto.comment.CommentUpdateRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    @Modifying
    @Query("update Comment c set comment_content = :content where c.board_no = :boardNo and c.member_id = :memberId")
    public Long modify(@Param("content") String content, @Param("boardNo") Long boardNo, @Param("memberId") String memberId);
}
