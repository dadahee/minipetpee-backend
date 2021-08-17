package com.j2kb.minipetpee.api.album;

import com.j2kb.minipetpee.api.album.dto.request.SaveAlbumPostCommentRequest;
import com.j2kb.minipetpee.api.album.dto.request.SaveAlbumPostRequest;
import com.j2kb.minipetpee.api.album.dto.request.UpdateAlbumPostRequest;
import com.j2kb.minipetpee.api.album.dto.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/apis/{homepee-id}/album/posts")
public class AlbumController {

    //게시글 등록
    @PostMapping
    public ResponseEntity<SaveAlbumPostResponse> saveAlbumPost(
            @PathVariable(name = "homepee-id") Long homepeeId,
            @RequestBody SaveAlbumPostRequest saveAlbumPostRequest
    ) {
        for(String albumPostImage : saveAlbumPostRequest.getImages())
            log.info("ImageUrl = {}", albumPostImage);

        SaveAlbumPostResponse saveAlbumPostResponse = new SaveAlbumPostResponse(1L);
        return ResponseEntity.ok(saveAlbumPostResponse);
    }

    //게시글 조회 - 전체 사진첩 내용 모두 조회
    @GetMapping
    public ResponseEntity<List<AlbumPostResponse>> findAlbumPosts(
            @PathVariable(name = "homepee-id") Long homepeeId,
            @PageableDefault(size = 4, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        List<AlbumPostImageResponse> albumImage1 = new ArrayList<>();
        albumImage1.add(new AlbumPostImageResponse(1L, "image1URL"));
        albumImage1.add(new AlbumPostImageResponse(2L, "image2URL"));
        albumImage1.add(new AlbumPostImageResponse(3L, "image3URL"));

        AlbumPostResponse album1 = new AlbumPostResponse(1L,"title1", albumImage1, 100, true);

        List<AlbumPostImageResponse> albumImage2 = new ArrayList<>();
        albumImage2.add(new AlbumPostImageResponse(4L, "image3URL"));
        albumImage2.add(new AlbumPostImageResponse(5L, "image4URL"));

        AlbumPostResponse album2 = new AlbumPostResponse(2L,"title2", albumImage2, 1000, true);

        List<AlbumPostResponse> albumLists = new ArrayList<>();
        albumLists.add(album1);
        albumLists.add(album2);

        return ResponseEntity.ok(albumLists);
    }

    //게시글 수정
    @PutMapping
    public ResponseEntity<Void> updateAlbumPost(
            @PathVariable(name = "homepee-id") Long homepeeId,
            @RequestBody UpdateAlbumPostRequest updateAlbumPostRequest
    ) {
        return ResponseEntity.noContent().build();
    }

    //게시글에 댓글 작성
    @PostMapping("/{post-id}/comments")
    public ResponseEntity<SaveAlbumPostCommentResponse> saveAlbumPostComment(
            @PathVariable(name = "homepee-id") Long homepeeId,
            @PathVariable(name = "post-id") Long postId,
            @RequestBody SaveAlbumPostCommentRequest albumCommentRequest
    ) {
        AlbumPostCommentMemberResponse albumPostCommentMember = new AlbumPostCommentMemberResponse(2L,"minipet");
        SaveAlbumPostCommentResponse albumPostCommentResponse = new SaveAlbumPostCommentResponse(1L, albumCommentRequest.getContent(), albumPostCommentMember, LocalDateTime.now());
        return ResponseEntity.ok(albumPostCommentResponse);
    }

    //게시글 삭제
    @DeleteMapping("/{post-id}")
    public ResponseEntity<Void> deleteAlbumPost(
            @PathVariable(name = "homepee-id") Long homepeeId,
            @PathVariable(name = "post-id") Long postId
    ) {
        return ResponseEntity.noContent().build();
    }

    //게시글 댓글 삭제
    @DeleteMapping("/{post-id}/comments/{comment-id}")
    public ResponseEntity<Void> deleteAlbumComment(
            @PathVariable(name = "homepee-id") Long homepeeId,
            @PathVariable(name = "post-id") Long postId,
            @PathVariable(name = "comment-id") Long commentId
    ) {
        return ResponseEntity.noContent().build();
    }
}