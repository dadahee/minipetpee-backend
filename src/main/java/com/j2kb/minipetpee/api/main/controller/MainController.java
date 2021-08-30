package com.j2kb.minipetpee.api.main.controller;

import com.j2kb.minipetpee.api.board.domain.BoardPost;
import com.j2kb.minipetpee.api.main.controller.dto.response.*;
import com.j2kb.minipetpee.api.main.service.MainService;
import com.j2kb.minipetpee.api.member.domain.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "메인 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/apis")
public class MainController {

    private final MainService mainService;

    @Operation(summary = "인기 컨텐츠 조회")
    @GetMapping("/popular-posts")
    public ResponseEntity<PopularPostPaginationResponse> findPopularPosts(
            @PageableDefault(size = 5) Pageable pageable
    ) {
        Page<BoardPost> popularPosts = mainService.findPopularPosts(pageable);
        return ResponseEntity.ok(new PopularPostPaginationResponse(popularPosts));
    }

    @Operation(summary = "계정 검색")
    @GetMapping("/search-member")
    public ResponseEntity<SearchMemberPaginationResponse> searchMembers(
            @RequestParam("name") String name,
            @PageableDefault(size = 8) Pageable pageable
    ) {
        Page<Member> searchMembers = mainService.searchMembers(name, pageable);
        return ResponseEntity.ok(new SearchMemberPaginationResponse(searchMembers));
    }

    @Operation(summary = "게시글 검색")
    @GetMapping("/search-post")
    public ResponseEntity<SearchPostPaginationResponse> searchPosts(
            @RequestParam("title") String title,
            @PageableDefault(size = 8, sort = "title", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<BoardPost> searchPosts = mainService.searchPosts(title, pageable);
        return ResponseEntity.ok(new SearchPostPaginationResponse(searchPosts));
    }
}
