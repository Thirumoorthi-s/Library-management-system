package com.redleaf.Library.Management.System.repository;

import com.redleaf.Library.Management.System.model.BookCheckModel;
import com.redleaf.Library.Management.System.model.SubgenreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCheckRepository extends JpaRepository<BookCheckModel, Integer> {
    @Query("SELECT b.subgenreId FROM BookCheckModel b WHERE b.bookId = :bookId")
    List<Integer>findSubgenresByGenreId(@Param("bookId") Integer bookId);

    @Modifying
    @Query("DELETE FROM BookCheckModel b WHERE b.bookId = :bookId")
    void deleteBookById(@Param("bookId")int bookId);
}
