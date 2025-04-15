package com.redleaf.Library.Management.System.repository;

import com.redleaf.Library.Management.System.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {
}
