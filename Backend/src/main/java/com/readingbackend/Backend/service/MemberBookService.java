package com.readingbackend.Backend.service;

import com.readingbackend.Backend.model.Book;
import com.readingbackend.Backend.model.MemberBookId;
import com.readingbackend.Backend.model.MemberBook;
import com.readingbackend.Backend.repository.BookRepository;
import com.readingbackend.Backend.repository.MemberBookRepository;
import com.readingbackend.Backend.responses.MemberBookDto;
import com.readingbackend.Backend.responses.MemberBookPostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MemberBookService {
    private final MemberBookRepository memberBookRepository;
    private final BookService bookService;

    @Autowired
    public MemberBookService(MemberBookRepository memberBookRepository, BookService bookService) {
        this.memberBookRepository = memberBookRepository;
        this.bookService = bookService;
    }

    public List<MemberBookDto> getMemberBook(Long userId) {
        List<Object[]> result = memberBookRepository.findBookByUserId(userId);

        result.stream()
                .forEach(row -> {
                    if (row[4] == null) {
                        System.out.println("FOUND NULL row[4]");
                    } else {
                        System.out.println("row[4] = " + row[4]);
                    }
                });


        return result.stream()
                .map(row -> new MemberBookDto(row[0].toString(), row[1].toString(), row[2].toString(), row[3].toString(), row[4].toString()))
                .toList();
    }

    public List<MemberBookDto> getMemberBookByStatus(Long userId, String status) {
        List<Object[]> result = memberBookRepository.findBookByUserIdAndStatus(userId, status);
        return result.stream()
                .map(row -> new MemberBookDto(row[0].toString(), row[1].toString(), row[2].toString(), row[3].toString(), row[4].toString()))
                .toList();
    }

    public MemberBook addMemberBook(MemberBookPostRequest memberBookRequest) {
        MemberBook memberBook = new MemberBook(memberBookRequest.getBook().getBookId(), memberBookRequest.getUserId());

        Book isBook = bookService.getBook(memberBookRequest.getBook().getBookId());

        if (isBook == null) {
            Book book = new Book(
                    memberBookRequest.getBook().getBookId(),
                    memberBookRequest.getBook().getBookTitle(),
                    memberBookRequest.getBook().getCoverUrl(),
                    memberBookRequest.getBook().getAuthor());
            bookService.addBook(book);

        }

        memberBookRepository.save(memberBook);
        return memberBook;
    }

    public MemberBook updateMemberBook (MemberBook updatedMemberBook) {
        MemberBookId id = new MemberBookId(updatedMemberBook.getBookId(), updatedMemberBook.getUserId());
        Optional<MemberBook> existingMemberBook = memberBookRepository.findById(id);

        System.out.println(existingMemberBook);

        if (existingMemberBook.isPresent()) {
            MemberBook memberBookToUpdate = existingMemberBook.get();
            memberBookToUpdate.setBookId((updatedMemberBook.getBookId()));
            memberBookToUpdate.setUserId((updatedMemberBook.getUserId()));
            memberBookToUpdate.setStatus((updatedMemberBook.getStatus()));
            memberBookRepository.save(memberBookToUpdate);
            System.out.println(memberBookToUpdate);
            return memberBookToUpdate;
        }
        return null;
    }

    public void deleteMemberBook(String bookId, Long userId) {
        MemberBookId id = new MemberBookId(bookId, userId);
        memberBookRepository.deleteById(id);
    }

}
