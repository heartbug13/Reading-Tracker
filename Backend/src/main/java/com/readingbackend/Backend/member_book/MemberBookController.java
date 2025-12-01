package com.readingbackend.Backend.member_book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/member_book")
public class MemberBookController {

    private final MemberBookService memberBookService;

    public MemberBookController(MemberBookService memberBookService) {
        this.memberBookService = memberBookService;
    }

    @GetMapping
    public List<MemberBook> getMemberBooks(@RequestParam String userId, @RequestParam(required = false) String status) {
        if (status != null) {
            return memberBookService.getMemberBookByStatus(userId, status);
        } else {
            return memberBookService.getMemberBook(userId);
        }
    }

    @PostMapping
    public ResponseEntity<MemberBook> addMemberBook(@RequestBody MemberBook memberBook) {
        MemberBook createdMemberBook = memberBookService.addMemberBook(memberBook);
        return new ResponseEntity<>(createdMemberBook, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MemberBook> updateMemberBook(@RequestBody MemberBook updatedMemberBook) {
        MemberBook resultMemberBook = memberBookService.updateMemberBook(updatedMemberBook);
        if (resultMemberBook != null) {
            return new ResponseEntity<>(resultMemberBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
