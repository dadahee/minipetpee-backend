package com.j2kb.minipetpee.api.guestnote.controller;

import com.j2kb.minipetpee.api.guestnote.controller.dto.request.SaveGuestNoteRequest;
import com.j2kb.minipetpee.api.guestnote.controller.dto.request.UpdateGuestNoteRequest;
import com.j2kb.minipetpee.api.guestnote.controller.dto.response.GuestNotePaginationResponse;
import com.j2kb.minipetpee.api.guestnote.controller.dto.response.SaveGuestNoteResponse;
import com.j2kb.minipetpee.api.guestnote.domain.GuestNote;
import com.j2kb.minipetpee.api.guestnote.service.GuestNoteService;
import com.j2kb.minipetpee.security.jwt.JwtAuthenticationPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "방명록 API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/apis/{homepee-id}/guest/guest-notes")
public class GuestNoteController {

    private final GuestNoteService guestNoteService;

    @Parameter(in = ParameterIn.QUERY
            , description = "페이지 (0 부터 시작)"
            , name = "page"
            , content = @Content(schema = @Schema(type = "integer", defaultValue = "0")))
    @Parameter(in = ParameterIn.QUERY
            , description = "반환할 데이터 수"
            , name = "size"
            , content = @Content(schema = @Schema(type = "integer", defaultValue = "4")))
    @Operation(summary = "방명록 조회")
    @GetMapping
    public ResponseEntity<GuestNotePaginationResponse> findGuestNotes(
            @AuthenticationPrincipal JwtAuthenticationPrincipal principal,
            @PathVariable(name = "homepee-id") Long homepeeId,
            @ParameterObject @PageableDefault(size = 4, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Long currentUserHomepeeId = principal.getHomepeeId();
        Page<GuestNote> guestNotesPage = guestNoteService.findGuestNotes(homepeeId, currentUserHomepeeId, pageable);
        return ResponseEntity.ok().body(new GuestNotePaginationResponse(guestNotesPage));
    }

    @Operation(summary = "방명록 작성")
    @PostMapping
    @PreAuthorize("isAuthenticated() && hasAuthority('SAVE_POSTS')")
    public ResponseEntity<SaveGuestNoteResponse> saveGuestNote(
            @AuthenticationPrincipal JwtAuthenticationPrincipal principal,
            @PathVariable(name = "homepee-id") Long homepeeId,
            @Valid @RequestBody SaveGuestNoteRequest guestNoteRequest
    ) {
        //저장
        GuestNote guestNote = guestNoteService.saveGuestNote(homepeeId, guestNoteRequest);
        return ResponseEntity.ok(new SaveGuestNoteResponse(guestNote));
    }

    @Operation(summary = "방명록 수정")
    @PutMapping("/{guest-note-id}")
    @PreAuthorize("isAuthenticated() && hasAuthority('UPDATE_POSTS')")
    public ResponseEntity<Void> updateGuestNote(
            @AuthenticationPrincipal JwtAuthenticationPrincipal principal,
            @PathVariable(name = "homepee-id") Long homepeeId,
            @PathVariable(name = "guest-note-id") Long guestNoteId,
            @Valid @RequestBody UpdateGuestNoteRequest updateGuestNote
    ) {
        //수정 권한 체크 추가하기(토큰값으로)
        guestNoteService.updateGuestNote(homepeeId, guestNoteId, updateGuestNote);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "방명록 삭제")
    @DeleteMapping("/{guest-note-id}")
    @PreAuthorize("isAuthenticated() && hasAuthority('DELETE_POSTS')")
    public ResponseEntity<Void> deleteGuestNote(
            @AuthenticationPrincipal JwtAuthenticationPrincipal principal,
            @PathVariable(name = "homepee-id") Long homepeeId,
            @PathVariable(name = "guest-note-id") Long guestNoteId
    ) {
        //삭제 권한 체크 추가하기(토큰값으로)
        guestNoteService.deleteGuestNote(homepeeId, guestNoteId);
        return ResponseEntity.noContent().build();
    }
}
