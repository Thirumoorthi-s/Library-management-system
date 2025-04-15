package com.redleaf.Library.Management.System.repository;

import com.redleaf.Library.Management.System.model.LibrarySectionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibrarySectionRepository extends JpaRepository<LibrarySectionModel, Integer> {
    @Query("SELECT s FROM LibrarySectionModel s")
    List<LibrarySectionModel> findAllLibrarySectionNames();
}
