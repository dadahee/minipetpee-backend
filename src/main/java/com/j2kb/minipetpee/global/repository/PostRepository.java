package com.j2kb.minipetpee.api.board.repository;

import com.j2kb.minipetpee.api.board.domain.BoardPost;
import com.j2kb.minipetpee.global.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // 검색 - 조회순
    Page<Post> findAllByOrderByViewCountDesc(Pageable pageable);

    // 제목으로 검색
    Page<Post> findAllByTitleContainingIgnoreCaseOrderByCreatedAtDesc(String title, Pageable pageable);

    // 제목 + 본문 검색
//    Page<Post> findAllByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrderByCreatedAtDesc(String title, String content, Pageable pageable);
}
