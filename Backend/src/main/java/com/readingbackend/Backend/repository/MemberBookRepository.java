package com.readingbackend.Backend.repository;

import com.readingbackend.Backend.model.MemberBook;
import com.readingbackend.Backend.model.MemberBookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberBookRepository extends JpaRepository<MemberBook, MemberBookId> {
    void deleteById(MemberBookId id);

    @Query(value = """
            select b.bookid, b.booktitle, b.coverurl, b.author, mb.status from book b inner join member_book mb on b.bookid = mb.bookid where mb.userid = :userId
            """, nativeQuery = true)
    List<Object[]> findBookByUserId(@Param("userId") Long userId);
    @Query(value = """
            select b.bookid, b.booktitle, b.coverurl, b.author, mb.status 
            from book b inner join member_book mb 
            on b.bookid = mb.bookid 
            where mb.userid = :userId and upper(mb.status) = upper(:status)
            """, nativeQuery = true)
    List<Object[]> findBookByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);
    //Optional<MemberBook> findById(MemberBookId id);

}
