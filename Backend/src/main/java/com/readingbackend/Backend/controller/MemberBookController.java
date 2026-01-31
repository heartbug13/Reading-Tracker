package com.readingbackend.Backend.controller;

import com.readingbackend.Backend.model.MemberBook;
import com.readingbackend.Backend.responses.MemberBookDto;
import com.readingbackend.Backend.responses.MemberBookPostRequest;
import com.readingbackend.Backend.responses.MemberBookPutRequest;
import com.readingbackend.Backend.service.MemberBookService;
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
    public List<MemberBookDto> getMemberBooks(@RequestParam Long userId, @RequestParam String status) {
        if (!status.isEmpty()) {
            return memberBookService.getMemberBookByStatus(userId, status);
        } else {
            return memberBookService.getMemberBook(userId);
        }
    }

    @PostMapping
    public ResponseEntity<MemberBook> addMemberBook(@RequestBody MemberBookPostRequest memberBookRequest) {
        MemberBook createdMemberBook = memberBookService.addMemberBook(memberBookRequest);
        return new ResponseEntity<>(createdMemberBook, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MemberBook> updateMemberBook(@RequestBody MemberBookPutRequest memberBookRequest) {
        System.out.println(memberBookRequest);

        MemberBook updatedMemberBook = new MemberBook(memberBookRequest.getBookId(), memberBookRequest.getUserId(), memberBookRequest.getStatus());

        System.out.println(updatedMemberBook);
        MemberBook resultMemberBook = memberBookService.updateMemberBook(updatedMemberBook);
        if (resultMemberBook != null) {
            return new ResponseEntity<>(resultMemberBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
