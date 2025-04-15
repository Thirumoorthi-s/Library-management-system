package com.redleaf.Library.Management.System.repository;

import com.redleaf.Library.Management.System.model.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreModel, Integer> {
//    @Query("SELECT g FROM GenreModel g")
//    List<GenreModel> findAllGenres();

    @Query("SELECT g FROM GenreModel g WHERE g.librarySectionId = :librarySectionId")
    List<GenreModel> findGenreByLibrarySectionId(@Param("librarySectionId") int librarySectionId);
}
