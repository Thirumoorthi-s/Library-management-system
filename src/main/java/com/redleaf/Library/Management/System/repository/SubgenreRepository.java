package com.redleaf.Library.Management.System.repository;

import com.redleaf.Library.Management.System.model.BookCheckModel;
import com.redleaf.Library.Management.System.model.SubgenreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubgenreRepository extends JpaRepository<BookCheckModel, Integer> {
    @Query("SELECT s FROM SubgenreModel s WHERE s.genreId = :genreId")
    List<SubgenreModel> findAllSubgenres(@Param("genreId") int genreId);
}
