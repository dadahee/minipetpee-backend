package com.j2kb.minipetpee.global.repository;

import com.j2kb.minipetpee.api.album.domain.AlbumPost;
import com.j2kb.minipetpee.global.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<AlbumPost> findAllByTabId(Long tabId, Pageable pagable);

    Optional<AlbumPost> findByIdAndTabId(Long id, Long tabId);
}
