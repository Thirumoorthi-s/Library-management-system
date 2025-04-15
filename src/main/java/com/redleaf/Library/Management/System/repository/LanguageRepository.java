package com.redleaf.Library.Management.System.repository;

import com.redleaf.Library.Management.System.model.LanguageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LanguageRepository extends JpaRepository<LanguageModel, Integer> {
    @Query("SELECT l FROM LanguageModel l")
    List<LanguageModel> findAllLanguageNames();
}
