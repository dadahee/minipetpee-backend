package com.j2kb.minipetpee.api.guestnote.controller;

import com.j2kb.minipetpee.api.guestnote.controller.dto.request.SaveGuestNoteRequest;
import com.j2kb.minipetpee.api.guestnote.controller.dto.request.UpdateGuestNoteRequest;
import com.j2kb.minipetpee.api.guestnote.controller.dto.response.GuestNoteResponse;
import com.j2kb.minipetpee.api.guestnote.controller.dto.response.GuestNoteMemberResponse;
import com.j2kb.minipetpee.api.guestnote.controller.dto.response.SaveGuestNoteResponse;
import com.j2kb.minipetpee.api.guestnote.domain.GuestNote;
import com.j2kb.minipetpee.api.guestnote.service.GuestNoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/apis/{homepee-id}/guest/guest-notes")
public class GuestNoteController {

    private final GuestNoteService guestNoteService;

    //방명록 조회
    @GetMapping
    public ResponseEntity<List<GuestNoteResponse>> findGuestNote(
            @PathVariable(name = "homepee-id") Long homepeeId
    ) {
        List<GuestNote> guestNotes = guestNoteService.findGuestNote(homepeeId);

        List<GuestNoteResponse> guestNoteResponses = new ArrayList<>();
        guestNotes.forEach(guestNote -> {
            GuestNoteMemberResponse member = new GuestNoteMemberResponse(guestNote);
            guestNoteResponses.add(new GuestNoteResponse(member, guestNote));
        });

        return ResponseEntity.ok().body(guestNoteResponses);
    }

    //방명록 작성
    @PostMapping
    public ResponseEntity<SaveGuestNoteResponse> saveGuestNote(
            @PathVariable(name = "homepee-id") Long homepeeId,
            @Valid @RequestBody SaveGuestNoteRequest guestNoteRequest
    ) {
        //저장
        GuestNote guestNote = guestNoteService.saveGuestNote(homepeeId, guestNoteRequest);
        GuestNoteMemberResponse member = new GuestNoteMemberResponse(guestNote);
        return ResponseEntity.ok(new SaveGuestNoteResponse(guestNote, member));
    }

    //방명록 수정
    @PutMapping("/{guest-note-id}")
    public ResponseEntity<Void> updateGuestNote(
            @PathVariable(name = "homepee-id") Long homepeeId,
            @PathVariable(name = "guest-note-id") Long guestNoteId,
            @RequestBody UpdateGuestNoteRequest updateGuestNote
    ) {
        return ResponseEntity.noContent().build();
    }

    //방명록 삭제
    @DeleteMapping("/{guest-note-id}")
    public ResponseEntity<Void> deleteGuestNote(
            @PathVariable(name = "homepee-id") Long homepeeId,
            @PathVariable(name = "guest-note-id") Long guestNoteId
    ) {
        return ResponseEntity.noContent().build();
    }
}
