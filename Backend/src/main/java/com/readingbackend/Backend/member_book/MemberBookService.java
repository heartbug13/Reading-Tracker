package com.readingbackend.Backend.member_book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MemberBookService {
    private final MemberBookRepository memberBookRepository;

    @Autowired
    public MemberBookService(MemberBookRepository memberBookRepository) {
        this.memberBookRepository = memberBookRepository;
    }

    public List<MemberBook> getMemberBook(String userId) {
        return memberBookRepository.findAll().stream()
                .filter(memberBook -> memberBook.getUserId().equalsIgnoreCase(userId))
                .collect(Collectors.toList());
    }

    public List<MemberBook> getMemberBookByStatus(String userId, String status) {
        return getMemberBook(userId).stream()
                .filter(memberBook -> memberBook.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public MemberBook addMemberBook(MemberBook memberBook) {
        memberBookRepository.save(memberBook);
        return memberBook;
    }

    public MemberBook updateMemberBook (MemberBook updatedMemberBook) {
        MemberBookId id = new MemberBookId(updatedMemberBook.getBookId(), updatedMemberBook.getUserId());
        Optional<MemberBook> existingMemberBook = memberBookRepository.findById(id);

        if (existingMemberBook.isPresent()) {
            MemberBook memberBookToUpdate = existingMemberBook.get();
            memberBookToUpdate.setBookId((updatedMemberBook.getBookId()));
            memberBookToUpdate.setUserId((updatedMemberBook.getUserId()));
            memberBookToUpdate.setStatus((updatedMemberBook.getStatus()));
            memberBookToUpdate.setStartDate((updatedMemberBook.getStartDate()));
            memberBookToUpdate.setEndDate((updatedMemberBook.getEndDate()));
            return memberBookToUpdate;
        }
        return null;
    }

    public void deleteMemberBook(String bookId, String userId) {
        MemberBookId id = new MemberBookId(bookId, userId);
        memberBookRepository.deleteById(id);
    }

}
