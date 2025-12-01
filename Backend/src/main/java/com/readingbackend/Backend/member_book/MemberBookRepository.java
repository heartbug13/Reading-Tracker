package com.readingbackend.Backend.member_book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberBookRepository extends JpaRepository<MemberBook, MemberBookId> {
    void deleteById(MemberBookId id);

    //Optional<MemberBook> findById(MemberBookId id);
}
